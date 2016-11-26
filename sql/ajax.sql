CREATE DATABASE IF NOT EXISTS ajax_jaon;
DROP TABLE IF EXISTS ajax_jaon.user;
CREATE TABLE ajax_jaon.user(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  email VARBINARY(255) NOT NULL ,
  password VARBINARY(255) NOT NULL 
);
INSERT INTO ajax_jaon.user VALUES (NULL ,'18310996173xiaozuo@gmail.com','1');
SELECT *
FROM ajax_jaon.user;