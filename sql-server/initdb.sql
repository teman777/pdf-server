CREATE DATABASE IF NOT EXISTS PDF;
USE PDF;
CREATE TABLE IF NOT EXISTS book(
  id int PRIMARY KEY AUTO_INCREMENT
 ,Name varchar(50)
 ,Author varchar(50)
 ,URL varchar(255)
);
CREATE TABLE IF NOT EXISTS bookmark(
	id int PRIMARY KEY AUTO_INCREMENT
       ,bookId int
       ,dateCreated date
      ,FOREIGN KEY (bookId) REFERENCES book(id) ON DELETE CASCADE
);
commit;
