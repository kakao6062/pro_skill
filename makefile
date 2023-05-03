all:
	javac DBTest.java
	java -classpath ".:sqlite-jdbc-3.41.2.1.jar" DBTest
	rm -f *.class