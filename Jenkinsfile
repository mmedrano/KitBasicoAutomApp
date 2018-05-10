// This shows a simple build wrapper example, using the AnsiColor plugin.
	
	pipeline { 

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

