CREATE SCHEMA tdlist DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS tdlist.user
(
  id VARCHAR(32) PRIMARY KEY,
  email VARCHAR(32) NOT NULL UNIQUE,
  password VARCHAR(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS tdlist.taskList
(
  id VARCHAR(32) PRIMARY KEY,
  name VARCHAR(32) NOT NULL UNIQUE,
  user_id VARCHAR(32) NOT NULL,
  FOREIGN KEY (user_id)
  REFERENCES tdlist.user(id)
);

CREATE TABLE IF NOT EXISTS tdlist.task
(
  id VARCHAR(32) PRIMARY KEY,
  name VARCHAR(32) NOT NULL UNIQUE,
  taskDate DATE,
  taskList_id VARCHAR(32) NOT NULL,
  FOREIGN KEY (taskList_id)
  REFERENCES tdlist.taskList(id)
);