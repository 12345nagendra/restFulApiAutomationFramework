pipeline {
    agent any
    triggers {
        cron('H/15 * * * *')  // Schedule to run every 15 minutes
    }
    stages {
        stage('Check for Changes') {
            steps {
                script {
                    def scmChanges = checkout scm: [
                        $class: 'GitSCM',
                        branches: [[name: '*/master']], // Adjust branch name as needed
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [[$class: 'CleanCheckout']],
                        userRemoteConfigs: [[url: 'https://github.com/12345nagendra/restFulApiAutomationFramework.git']]
                    ]

                    if (scmChanges.empty) {
                        echo 'No changes detected'
                        currentBuild.result = 'NOT_BUILT'
                        return
                    }
                }
            }
        }
        stage('Build') {
            when {
                not {
                    equals expected: 'NOT_BUILT', actual: currentBuild.result
                }
            }
            steps {
                echo 'Building...'
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            when {
                not {
                    equals expected: 'NOT_BUILT', actual: currentBuild.result
                }
            }
            steps {
                echo 'Testing...'
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            when {
                not {
                    equals expected: 'NOT_BUILT', actual: currentBuild.result
                }
            }
            steps {
                echo 'Deploying...'
                // Deployment steps
            }
        }
    }
}
