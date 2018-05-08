// This shows a simple build wrapper example, using the AnsiColor plugin.
	pipeline { 
		agent any 
		triggers { pollSCM('* * * * *') }
		
		
		
		stages {
			stage('Build') { 
				steps { 
					bat "build.bat"
					
				}
			}
			stage('Deploy') { 
				steps { 
					bat "deploy.bat"
				}
			}
			stage('Versionar') {
			//def server = Artifactory.server "http://localhost:8081/artifactory"
			//def rtGradle = Artifactory.newGradleBuild()
			//def buildInfo
			
			//buildInfo = rtGradle.run rootDir: "KitBasicoAutomApp/", buildFile: 'build.gradle', tasks: 'clean build'
			
				//rtGradle.deployer repo:'example-repo-local', server: server
				//rtGradle.resolver repo:'example-repo-local', server: server
				//server.publishBuildInfo buildInfo
			}			
		}
		
	}