pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Spring Boot Application') {
            steps {
                sh 'sudo java -jar target/employeemanagement-0.0.1-SNAPSHOT.jar&'
            }
        }
    }

    post {
        success {
            echo 'Build and Deployment Successful'
        }

        failure {
            echo 'Build or Deployment Failedd'
        }
    }
}