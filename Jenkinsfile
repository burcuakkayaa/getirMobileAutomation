node {

   tools {
        maven 'MAVEN_3.6.3'
        jdk 'JDK_1.8.0_261'
    }

   stages {

    stage('Checkout Code') {

        git 'https://github.com/burcuakkayaa/getirMobileAutomation.git' , branch:'master'
    }

    stage('Build') {
         echo "Building.."

         if (isUnix()) {
            sh 'mvn -B -DskipTests clean package'
         } else {
            bat script:"mvn clean install"
         }
    }

    stage('Test') {
          echo "Test started.."
                  if (isUnix()) {
                     sh 'mvn test'
                  } else {
                     bat script:"mvn test"
                  }
    }

    stage('Done')
        {
                echo "it is all done !!"

        }

    }
} 