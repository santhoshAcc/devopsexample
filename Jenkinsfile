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
        
         stage ('SAST') {
              steps {
                withSonarQubeEnv('sonar') {
                  sh 'mvn sonar:sonar'
                  sh 'cat target/sonar/report-task.txt'
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
