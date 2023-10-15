CREATE TABLE IF NOT EXISTS books ( 
  id int PRIMARY KEY AUTO_INCREMENT , 
  title varchar(100) NOT NULL ,
  author varchar(100) NOT NULL ,
  editorial varchar(50) NOT NULL ,
  fecha date NOT NULL ,
  theme varchar(50) NOT NULL 
);
  
CREATE TABLE IF NOT EXISTS users (  
  id int PRIMARY KEY AUTO_INCREMENT ,
  user varchar(30) NOT NULL UNIQUE,
  password varchar(30) NOT NULL 
);