def call() {
  pipeline {
    agent any
    triggers { pollSCM '* * * * *'}
    environment {
        REPO_NAME = sh(script: 'basename -s .git `git config --get remote.origin.url`', returnStdout: true).trim()
        BUILD_NUMBER = "${env.BUILD_NUMBER}"
        BRANCH_NAME = "${env.BRANCH_NAME}"
    }
      stages {
          stage('Checkout') {
              steps {
                  script {
                      // Checkout the current branch
                      checkout scm
                      // Print the current branch
                  }
              }
          }
        stage('docker build'){
          steps {
            script {
              withCredentials([usernamePassword(credentialsId: 'jfrog', passwordVariable: 'jfrogpasswd', usernameVariable: 'jfroguser')]) {
                sh "docker image build -t spring:1.5.0 ."
                sh "docker tag spring:1.5.0 ramakrishna7899.jfrog.io/dev-docker-docker/nginx:1.0.0"
                sh "docker login ramakrishna7899.jfrog.io -u ${jfroguser} -p ${jfrogpasswd}"
                sh "docker push ramakrishna7899.jfrog.io/dev-docker-docker/nginx:1.0.0" 
              }
            }
          }
        }
      }
  }

}
