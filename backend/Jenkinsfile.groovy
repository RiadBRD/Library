pipeline {
    agent any

    // Trigger GitHub Push pour tester le webhook
    triggers {
        githubPush()
        // Optionnel : pollSCM pour debug si GitHubPush ne déclenche pas
        // pollSCM('H/5 * * * *')
    }

    stages {
        stage('Start') {
            steps {
                echo "=== Nouveau build déclenché ==="
                echo "Job: ${env.JOB_NAME}"
                echo "Build Number: ${env.BUILD_NUMBER}"
                echo "Branch: ${env.BRANCH_NAME ?: 'non spécifié'}"
            }
        }

        stage('Checkout') {
            steps {
                echo "🔄 Checkout du code..."
                git(branch: 'main', url: 'https://github.com/RiadBRD/Library.git')
            }
        }

        stage('Build') {
            steps {
                echo "🛠️ Build en cours avec Maven..."
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo "✅ Lancement des tests..."
                sh 'mvn test'
            }
        }

        stage('Archive') {
            steps {
                echo "📦 Archivage des artifacts..."
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '🎉 Build et tests réussis !'
        }

        failure {
            echo '❌ Le build a échoué'
        }
    }
}
