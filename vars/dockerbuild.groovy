def call() {
  pipeline {
    agent any
    environment {
        REPO_NAME = sh(script: 'basename -s .git `git config --get remote.origin.url`', returnStdout: true).trim()
        BUILD_NUMBER = "${env.BUILD_NUMBER}"
    }
      stages {
          stage('Checkout') {
              steps {
                  script {
                      // Checkout the current branch
                      checkout scm
                      // Print the current branch
                      echo "Current branch: ${env.BRANCH_NAME}"
                  }
              }
          }
        stage('docker build'){
          steps {
            script {
              if (env.BRANCH_NAME == 'Master' | env.BRANCH_NAME == 'main'){
                sh "docker image build -t ${REPO_NAME}:${BUILD_NUMBER} ."
              }
            }
          }
        }
      }
  }
}
