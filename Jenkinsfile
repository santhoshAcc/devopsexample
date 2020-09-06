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
              sh 'cat /var/lib/jenkins/OWASP-Dependency-Check/reports/dependency-check-report.xml'
           }
        }
        
        stage('SonarQube analysis') {
             steps {
                withSonarQubeEnv('devsecops') { // Will pick the global server connection you have configured
                 sh './gradlew sonar' 
                }
             }
        }
                
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
