DROP TABLE IF EXISTS USERS;
 
CREATE TABLE USERS (
  id INT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  status VARCHAR(250) DEFAULT 'ACTIVE' NOT NULL,
  created_by VARCHAR(250) DEFAULT 'SYSTEM' NOT NULL,
  updated_by VARCHAR(250) DEFAULT 'SYSTEM' NOT NULL,
  created_timestamp VARCHAR(250) DEFAULT sysdate,
  updated_timestamp VARCHAR(250) DEFAULT sysdate
);

INSERT INTO USERS (id, first_name, last_name, email) 
VALUES
  (1, 'Virat', 'Kohli', 'virat.kohli@bcci.com'),
  (2, 'Ben', 'Stokes', 'bem.stoles@ecb.com'),
  (3, 'Robert', 'Smith', 'robert.smith@ecb.com'),
  (4, 'James', 'Gosling', 'james.gosling@java.com'),
  (5, 'Albert', 'Einstein', 'albert.einstein@emc2.com');