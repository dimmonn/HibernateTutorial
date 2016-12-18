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

##### usage: Main
##### -ae,--edit <arg>        Add an employee
##### -ed,--edit <arg>        Edit an existing dept
##### -fe,--findemp <arg>     Find emp by id
##### -fn,--finddept <arg>    Find dept by id
##### -h,--help               show help.
##### -nd,--add <arg>         Add new dept
##### -re,--removeemp <arg>   remove emp by id
##### -rm,--remove <arg>      Remove an existing dept
##### -sh,--show              Show an existing dept
