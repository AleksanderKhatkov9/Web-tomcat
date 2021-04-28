/*Drop*/
Drop database webdb;
drop table user;
drop table book;

/*Create*/
CREATE DATABASE webdb;
USE webdb;
CREATE TABLE user (
   user_id INT PRIMARY KEY AUTO_INCREMENT,
   user_name varchar(20) DEFAULT NULL,
   password varchar(20) DEFAULT NULL,
   email varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table book(
	id INT PRIMARY KEY AUTO_INCREMENT,
	title varchar(20) DEFAULT NULL,
	author varchar(20) DEFAULT NULL,
	price varchar(20) DEFAULT NULL,
	user_id int  REFERENCES book (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




