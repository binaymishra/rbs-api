DROP TABLE AUTHORIZATION_TABLE IF EXISTS;
DROP TABLE PERMISSION_TABLE IF EXISTS;
DROP TABLE ROLE_TABLE IF EXISTS;
DROP TABLE USER_TABLE IF EXISTS;

CREATE TABLE USER_TABLE (
	user_id BIGINT,
	user_name VARCHAR(100) DEFAULT NULL,
	user_password VARCHAR(100) DEFAULT NULL,
	CONSTRAINT pk_user_id PRIMARY KEY (user_id)
);

CREATE TABLE ROLE_TABLE (
	role_id BIGINT,
	role_name VARCHAR(100) DEFAULT NULL,
	CONSTRAINT pk_role_id PRIMARY KEY (role_id)
);

CREATE TABLE PERMISSION_TABLE (
	permission_id BIGINT,
	permission_name VARCHAR(100) DEFAULT NULL,
	permission_enable boolean DEFAULT FALSE,
	CONSTRAINT pk_permission_id PRIMARY KEY (permission_id)
);

CREATE TABLE AUTHORIZATION_TABLE (
	auth_user_id BIGINT,
	auth_role_id BIGINT,
	auth_permission_id BIGINT, 
	FOREIGN KEY (auth_user_id) REFERENCES USER_TABLE (user_id),
	FOREIGN KEY (auth_role_id) REFERENCES ROLE_TABLE (role_id),
	FOREIGN KEY (auth_permission_id) REFERENCES PERMISSION_TABLE (permission_id)
);



