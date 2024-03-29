 drop table if exists Task;
 drop table if exists Role;
 drop table if exists Employee;


 CREATE TABLE Task (id INTEGER NOT NULL AUTO_INCREMENT,
                     name VARCHAR(255) NOT NULL,
                      description varchar(500),
                       priority varchar(6) DEFAULT 'NORMAL',
                       PRIMARY KEY (id)
                 );

 CREATE TABLE Role (id INTEGER NOT NULL AUTO_INCREMENT,
         name VARCHAR(5) NOT NULL DEFAULT 'USER',
           PRIMARY KEY (id));

 CREATE TABLE Employee (id INTEGER NOT NULL AUTO_INCREMENT,
     firstname VARCHAR(50) NOT NULL,
      lastname VARCHAR(50),
      username VARCHAR (50) NOT NULL,
      password VARCHAR(100) NOT NULL,
       salary INTEGER,
       position VARCHAR(50) DEFAULT 'EMPLOYEE',
       PRIMARY KEY (id)
 );

 CREATE TABLE ROLE_ASSIGN(employeeID INTEGER )
