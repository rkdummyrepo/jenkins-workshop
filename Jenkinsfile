@Library('common-lib') _

pipeline {
    agent any

    stages {
        stage('Example Stage') {
            steps {
                script {
                    // Using the shared library step
                    basic("Hello World!")
                    // Using the shared library class
                    def myLib = new com.example.MySharedLibrary()
                    myLib.echo("Hello World!")
                }
            }
        }
    }
}
