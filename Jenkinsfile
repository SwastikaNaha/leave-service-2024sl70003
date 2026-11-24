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
                    sh 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:3.11.0.3922:sonar -Dsonar.projectKey=leave-service-2024sl70003 -Dsonar.host.url=http://localhost:9000 -Dsonar.login=$SONAR_TOKEN'
                }
            }
        }
        stage('Package Jar and Build Docker Image') {
            steps {
                sh 'mvn clean package -DskipTests'
                sh 'docker build -t leave-service-2024sl70003:1.0 .'
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh 'docker rm -f leave-staging-2024sl70003 || true'
                sh 'docker run -d --name leave-staging-2024sl70003 -p 8085:8080 -e APP_ENV=staging leave-service-2024sl70003:1.0'
                sh 'sleep 2 && curl -f http://localhost:8085'
            }
        }
    }
}
