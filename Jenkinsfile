// This shows a simple build wrapper example, using the AnsiColor plugin.
	//pipeline { 
	
		
		
		agent {
		label 'kitbasico'
		triggers { pollSCM('* * * * *') }
			
			node{
			
			def server = Artifactory.server "http://localhost:8081/artifactory"
			def rtGradle = Artifactory.newGradleBuild()
			def buildInfo
			
			stages {
				
			
				stage('Build') { 
					steps { 
						//bat "build.bat"
						buildInfo = rtGradle.run rootDir: "KitBasicoAutomApp/", buildFile: 'build.gradle', tasks: 'clean build'
					}
				}
				stage('Deploy') { 
					steps { 
						bat "deploy.bat"
					}
				}
				stage('Versionar') {
					rtGradle.deployer repo:'example-repo-local', server: server
					rtGradle.resolver repo:'example-repo-local', server: server
					server.publishBuildInfo buildInfo
				}			
			}
			
			
			
			}
		}
		
	//}