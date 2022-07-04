
pipeline {
    agent any
    stages{
        stage('Build'){
            steps{
                bat 'mvn clean install -DskipTests=true'
            }
        }

        stage('Functional'){
            steps{
              bat 'mvn test -DTests=Functional'
            }
        }
    }
    post{
        always{
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
