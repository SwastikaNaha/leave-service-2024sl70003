pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube Code Inspection') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    sh 'mvn verify sonar:sonar -Dsonar.projectKey=leave-service-2024sl70003 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
    }
}
