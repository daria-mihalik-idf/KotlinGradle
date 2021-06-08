pipeline {
    agent any
    tools {
        jdk 'jdk8u172'
        gradle 'gradle-6.7'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        post {
            always {
                echo '..'
            }
        }
        stage('Get KotlinGradle code') {
            steps {
                echo 'Get code..'
                git credentialsId: 'b8b57a61-6ffd-490a-9c40-5df13df4650a', url: 'https://github.com/daria-mihalik-idf/KotlinGradle.git'
            }
        }
        stage('Run tests') {
            steps {
                bat 'gradle :uiTest'
            }
        }
        stage('Allure') {
            steps {
                echo 'Allure result generation....'
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}