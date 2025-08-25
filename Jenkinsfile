pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git(branch: 'main', url: 'https://github.com/RiadBRD/Library.git')
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build et tests réussis'
        }

        failure {
            echo 'Le build a échoué'
        }
    }
}
