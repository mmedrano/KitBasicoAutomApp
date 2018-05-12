// This shows a simple build wrapper example, using the AnsiColor plugin.
	
	pipeline { 
		agent any
		triggers { pollSCM('* * * * *') }
		stages {
			
			
			stage('Desplegar Pruebas') { 
				steps { 
					script{			          
						checkout([$class: 'GitSCM', 
						branches: [[name: '*/master']], 
						doGenerateSubmoduleConfigurations: false, 
						extensions: [[$class: 'RelativeTargetDirectory', 
							relativeTargetDir: 'KitBasicoAutomApp-Ops']], 
						submoduleCfg: [], 
						userRemoteConfigs: [[url: 'https://github.com/mauro2357/KitBasicoAutomApp-Ops.git']]])     
			      }
					bat 'mkdir "KitBasicoAutomApp/build/libs/config"'
					bat 'xcopy "KitBasicoAutomApp-Ops/config" "KitBasicoAutomApp/build/libs/config"'
					bat "deploy.bat"
				}
			}
			
		}
		
	}

