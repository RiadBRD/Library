pipeline {
    agent any
    triggers {
        githubPush()
    }
    stages {
        stage('Checkout') {
            steps {
                git(branch: 'main', url: 'https://github.com/RiadBRD/Library.git')
            }
        }

        stage('Build') {
            sh 'mvn clean package'
        }

        stage('Test') {
            sh 'mvn test'
        }A

        stage('Archive') {
            archiveArtifacts artifacts : 'target/*.jar',
            fingerprint:true
        }
    }

    post {
        success {
            echo 'Build et tests réussis'
        }

        failure {
            echo 'Le build a échoué !'
        }
    }
}
