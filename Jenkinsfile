// This shows a simple build wrapper example, using the AnsiColor plugin.
	pipeline { 
		agent any 
		// Create an Artifactory Gradle instance.
		def rtGradle = Artifactory.newGradleBuild()
		stages {
			stage('Build') { 
				steps { 
					script {
                        // some block
                        gradle build
						
                    }
				}
			}	
		}
		
	}