INSERT INTO cmsuser (username, display_name, is_locked, pass_hash, email) VALUES ('admin','Stephen',FALSE, '1000:ac80f7a1a90ba0d7a93880d0200e9ba0b44ee794d63a6fbf:3fe03ab851cf2dfc7f98f0349c564dae8f6ce851b13a47c6', 'admin@admin.net');
INSERT INTO roles SET role_name = 'ROLE_ADMIN';
INSERT INTO roles SET role_name = 'ROLE_USER';
INSERT INTO cmsuser_roles SET cmsuser_id=1, roles_id=1;
INSERT INTO cmsuser_roles SET cmsuser_id=1, roles_id=2;