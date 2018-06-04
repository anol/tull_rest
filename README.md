

java -cp target/tull_rest-1.0-SNAPSHOT.jar Application

mvn clean compile assembly:single
java -jar target/tull_rest-1.0-SNAPSHOT-jar-with-dependencies.jar Application