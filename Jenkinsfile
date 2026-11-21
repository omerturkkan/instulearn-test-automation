pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                withCredentials([
                    usernamePassword(credentialsId: 'instulearn-student',
                                     usernameVariable: 'STUDENT_EMAIL',
                                     passwordVariable: 'STUDENT_PASSWORD'),
                    usernamePassword(credentialsId: 'instulearn-teacher',
                                     usernameVariable: 'TEACHER_EMAIL',
                                     passwordVariable: 'TEACHER_PASSWORD')
                ]) {
                    sh './mvnw -B test -Dremote=true -Dgrid.url=http://selenium-chrome:4444'
                }
            }
        }
    }
}
