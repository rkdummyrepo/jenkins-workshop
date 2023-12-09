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
                sh "docker image build -t spring:1.4.0 ."
                sh "docker images ls"
            }
          }
        }
      }
  }

}
