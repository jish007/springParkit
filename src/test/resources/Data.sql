
DROP TABLE IF EXISTS roles;

DROP TABLE IF EXISTS roles_master;



CREATE TABLE roles_master (
  rolename varchar(255) NOT NULL,
  responsibilities varchar(255) DEFAULT NULL,
  PRIMARY KEY (rolename)
);
CREATE TABLE roles (
  rolename varchar(255) NOT NULL,
  responsibilities varchar(255) DEFAULT NULL,
  admin_mail_id varchar(50) DEFAULT NULL,
  id int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id)
);


INSERT INTO roles (rolename, responsibilities, admin_mail_id, id)
VALUES ('Auto Entry and Exit', 'automated barriers for entry and exit', 'gokulgnair777@gmail.com', 29);
INSERT INTO roles_master (rolename, responsibilities) VALUES
('Auto Entry and Exit', 'automated barriers for entry and exit'),
('Qr code Entry and Exit', 'without automated barriers for entry and exit');
