// This shows a simple build wrapper example, using the AnsiColor plugin.
	
	pipeline { 
		agent { docker 'maven:3-alpine' }
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
		}
		
	}

