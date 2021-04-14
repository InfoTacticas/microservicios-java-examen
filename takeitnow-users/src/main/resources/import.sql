INSERT INTO `users` (username, password, active, first_name, last_name, email) VALUES ('srdelarosab','123456',1, 'Renato', 'De la Rosa','srdelarosab@gmail.com');
INSERT INTO `users` (username, password, active, first_name, last_name, email) VALUES ('admin','123456',1, 'Sergio', 'De la Rosa','srdelarosab@icloud.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);