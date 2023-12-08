@Library('common-lib') _

pipeline {
    agent any

    stages {
        stage('Example Stage') {
            steps {
                script {
                    // Using the shared library step
                    basic("Hello World!")
                }
            }
        }
    }
}
