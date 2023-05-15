all:
	javac Integration.java
	java -classpath ".:sqlite-jdbc-3.41.2.1.jar" Integration
	rm -f *.class

