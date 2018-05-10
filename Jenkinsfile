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
			stage('Analisis de código') { 
				steps { 
					bat "anali_code.bat"
					
				}
			}
			
			stage('Deploy') { 
				steps { 
					bat "deploy.bat"
				}
			}

		stage('Versionar'){
            steps {
                script{
                    // Obtain an Artifactory server instance, defined in Jenkins --> Manage:
                    def server = Artifactory.server 'Jenkins-Local'

					def uploadSpec = """{
					  "files": [
						{
						  "pattern": "*.jar",
						  "target": "kit-basico-repository"
						}
					 ]
					}"""
					def buildInfo2=server.upload(uploadSpec)
					
					server.publishBuildInfo buildInfo2
	
                }
            }
        }			
		}
		
	}

