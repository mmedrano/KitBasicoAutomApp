cd KitBasicoAutomApp
gradle -Dflyway.configFiles=../DefaultFlywayConfig.config flywayRepair flywayMigrate
cd build\libs
java -jar KitBasicoAutomatizacion.jar
