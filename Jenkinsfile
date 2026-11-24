pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Source code checked out successfully'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn -B clean verify'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('SonarQube Code Inspection') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                        mvn -B sonar:sonar \
                        -Dsonar.projectKey=leave-service-2024SL70008 \
                        -Dsonar.host.url="$SONAR_HOST_URL" \
                        -Dsonar.token="$SONAR_AUTH_TOKEN" \
                        -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
                    '''
                }
            }
        }
    }
}
