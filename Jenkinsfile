pipeline {
    agent any
    stages {
        stage('Build jar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
               bat "docker build -t '291119901/selenium-docker' ."
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
