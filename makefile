all:
	javac IntegrationTest.java
	java -classpath ".:sqlite-jdbc-3.41.2.1.jar" IntegrationTest
	rm -f *.class

intetest:
	javac -cp .:lib/junit-4.13.2.jar DB.java
	javac -cp .:lib/junit-4.13.2.jar Process.java
	javac -cp .:lib/junit-4.13.2.jar HasAccessProcess.java
	javac -cp .:lib/junit-4.13.2.jar NoAccessProcess.java
	javac -cp .:lib/junit-4.13.2.jar ProcessPattern.java
	javac -cp .:lib/junit-4.13.2.jar Integration.java
	rm *.class
#	javac -cp .:lib/junit-4.13.2.jar IntegrationTest.java
#	java -cp .:lib/junit-4.13.2.jar
#	org.junit.runner.JUnitCore IntegrationTest