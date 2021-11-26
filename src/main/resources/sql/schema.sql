CREATE TABLE IF NOT EXISTS users
(
    user_id  BIGINT PRIMARY KEY auto_increment,
    username VARCHAR(128) UNIQUE NOT NULL,
    email    VARCHAR(128) UNIQUE NOT NULL,
    password VARCHAR NOT NULL

);
