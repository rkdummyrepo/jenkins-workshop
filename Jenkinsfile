@Library('common-lib') _

def myLib = new com.example.sampleclass()

pipeline {
    agent any

    stages {
        stage('Example Stage') {
            steps {
                script {
                    // Using the shared library step
                    basic("Hello World!")
                    echo "mylib"
                    myLib()
                }
            }
        }
    }
}
