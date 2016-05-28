
INSERT INTO USER_TABLE (user_id, user_name, user_password) VALUES (1, 'vinay', 'bWlzaHJh');

INSERT INTO ROLE_TABLE (role_id, role_name) VALUES (1, 'ROLE_USER');
INSERT INTO ROLE_TABLE (role_id, role_name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO PERMISSION_TABLE (permission_id, permission_name, permission_enable) VALUES (1, 'VNPK_COST_UPDATE', true);
INSERT INTO PERMISSION_TABLE (permission_id, permission_name, permission_enable) VALUES (2, 'VNPK_COST_READ', true);
INSERT INTO PERMISSION_TABLE (permission_id, permission_name, permission_enable) VALUES (3, 'VNPK_COST_DELETE', true);

INSERT INTO AUTHORIZATION_TABLE (auth_user_id, auth_role_id, auth_permission_id) VALUES (1, 1, 1);
INSERT INTO AUTHORIZATION_TABLE (auth_user_id, auth_role_id, auth_permission_id) VALUES (1, 1, 2);
INSERT INTO AUTHORIZATION_TABLE (auth_user_id, auth_role_id, auth_permission_id) VALUES (1, 2, 1);
INSERT INTO AUTHORIZATION_TABLE (auth_user_id, auth_role_id, auth_permission_id) VALUES (1, 2, 2);
INSERT INTO AUTHORIZATION_TABLE (auth_user_id, auth_role_id, auth_permission_id) VALUES (1, 2, 3);



 