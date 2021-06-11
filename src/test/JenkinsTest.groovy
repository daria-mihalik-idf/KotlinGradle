pipeline {
    agent any

    triggers {
        cron('0 0 0 * * ?')
    }

    tools {
        jdk 'jdk8u172'
        gradle 'gradle-6.7'
    }

    stages {
        stage('Get KotlinGradle code') {
            steps {
                echo 'Get code..'
                git credentialsId: 'b8b57a61-6ffd-490a-9c40-5df13df4650a', url: 'https://github.com/daria-mihalik-idf/KotlinGradle.git'
            }
        }
        stage('Run tests') {
            steps {
                gradle.bat test
            }
        }
        stage('Allure') {
            steps {
                echo 'Allure result generation....'
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
    post {
       always {
           junit skipPublishingChecks: true, testResults: 'test-results.xml'

       }
    }
}