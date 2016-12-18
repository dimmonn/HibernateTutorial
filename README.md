# Hibernate Simple Tutorial
Hibernate Simple Tutorial using spring transactions

# Installation

1. install mysql db with "dnName" database name
2. set up username and a password with privs granted to the dbName
3. update spring.xml file like below

####		<property name="driverClassName" value="com.mysql.jdbc.Driver" />
####		<property name="url" value="jdbc:mysql://ip:3306/dbName" />
####		<property name="username" value="root" />
####		<property name="password" value="pass" />

relations of the tables being updated by this tutorial is below
![img](https://github.com/dimmonn/HibernateTutorial/blob/master/src/main/resources/dbDiagram.PNG)

# Run

1. run the library like below

##java -jar SpringWithHibernate-Version.jar "usage",

#####where usage is:

#####usage: Main
##### -ae,--addEmpl <arg>      Add an employee to an existing dept (ex. -ae
                          "employee inamed")
##### -ed,--editDept <arg>     Edit an existing dept (ex. -ed "department id")
##### -fe,--findEmpl <arg>     Find emp by id (ex. -fe "employee id")
##### -fn,--findDept <arg>     Find dept by id (ex. -fn "department id")
##### -h,--help                show help
##### -nd,--addDept <arg>      Add new dept (ex. -nd "department name")
##### -re,--removeEmp <arg>    remove emp by id (ex. -re "employee id")
##### -rm,--removeDept <arg>   Remove an existing dept (ex. -rm "department
                          id")
##### -sh,--showDept           Show an existing dept (ex. -sh "department id")

