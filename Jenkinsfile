pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh './mvnw -B test -Dremote=true -Dgrid.url=http://selenium-chrome:4444 "-Dcucumber.filter.name=Visitor sees the easy links on the top navbar"'
            }
        }
    }
}
