pipeline {
    agent any

    stages {
              
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        
        stage ('Source Composition Analysis') {
            steps {
              sh 'rm owasp* || true'
              sh 'wget "https://raw.githubusercontent.com/santhoshAcc/devopsexample/master/owasp-dependency-check.sh" '
              sh 'chmod +x owasp-dependency-check.sh'
              sh 'bash owasp-dependency-check.sh'
           }
        }
                
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
