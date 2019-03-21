## DatDat JDBC 

## 1. Install ##
Linux Ubuntu
-------------------------

1. Install Java -> Mysql driver:
	```bash
	$ sudo apt-get install libmysql-java
	```

2. Export path to driver:
	```bash
	$ export CLASSPATH=./:/usr/share/java/mysql-connector-java.jar
	```

## 2. run project files ##

1. Compile project:
	```bash
	$ javac DatabaseConnectivity.java
	```

2. Run class:
	```bash
	$ java MysqlCon
	```
## 3. run project as .jar ##

1. Make executable:

2. Run class:
	```bash
	$ java -jar workoutlog.jar
