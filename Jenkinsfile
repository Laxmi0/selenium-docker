pipeline {
    agent none
    stages {
        stage('Build jar') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
               bat "docker build -t='291119901/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
               withCredentials([usernamePassword(credentialsId:'dockerhub',passwordVariable:'Pintu@1985.',usernameVariable:'291119901')])
                   bat "docker login --username=${user} --password=${pass}"
                   bat "docker push 291119901/selenium-docker" 
                }
            }
        }
    }
}
