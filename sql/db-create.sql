DROP TABLE users_groups;
DROP TABLE users;
DROP TABLE groups;


CREATE TABLE users (
id int PRIMARY KEY NOT NULL auto_increment,
login VARCHAR (20) UNIQUE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE groups (
id int PRIMARY KEY NOT NULL auto_increment,
name VARCHAR (20) UNIQUE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users_groups (
user_id int NOT NULL,
foreign key(user_id) REFERENCES users (id)
ON DELETE CASCADE ON UPDATE CASCADE,
group_id int NOT NULL,
FOREIGN KEY (group_id) REFERENCES groups (id)
ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (user_id, group_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO users VALUES (default, 'ivanov');
INSERT INTO groups VALUES (DEFAULT, 'teamA');