// This shows a simple build wrapper example, using the AnsiColor plugin.
	
	pipeline { 
		agent any
		triggers { pollSCM('* * * * *') }
		stages {
			stage('Build') { 
				steps { 
					powershell 'wget http://localhost:8082/shutdown'
					bat "build.bat"
					
				}
			}
			stage('Analisis de código') { 
				steps { 
					bat "anali_code.bat"
					
				}
			}
			
			stage('Desplegar Integración') { 
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
			
			stage('Desplegar Pruebas') { 
				steps { 
					powershell 'md build\\libs\\config'
					powershell 'wget https://github.com/mauro2357/KitBasicoAutomApp-Ops/blob/master/config/application.properties -OutFile build\libs\config\application.properties'
					bat "deploy.bat"
				}
			}
			
		}
		
	}

