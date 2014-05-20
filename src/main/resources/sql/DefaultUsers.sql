INSERT INTO cmsuser SET 
        username='admin', 
        display_name='Stephen', 
        is_locked=FALSE, 
        pass_hash='1000:ac80f7a1a90ba0d7a93880d0200e9ba0b44ee794d63a6fbf:3fe03ab851cf2dfc7f98f0349c564dae8f6ce851b13a47c6';
INSERT INTO roles SET
        role_name = 'ROLE_ADMIN';
INSERT INTO roles SET
        role_name = 'ROLE_USER';