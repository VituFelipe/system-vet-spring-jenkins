pipeline {
    agent any
    tools {
        maven 'Maven'
        jdk 'JDK'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/VituFelipe/system-vet-spring-jenkins.git', branch: 'master', credentialsId: 'github-credentials'
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
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                    archiveArtifacts 'target/site/jacoco/index.html'
                }
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
            }
        }
    }
}