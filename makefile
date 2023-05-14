all:
	javac IntegrationTest.java
	java -classpath ".:sqlite-jdbc-3.41.2.1.jar" IntegrationTest
	rm -f *.class

