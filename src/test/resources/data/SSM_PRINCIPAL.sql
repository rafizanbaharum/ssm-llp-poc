-- ORACLE
-- ADMIN
insert into SSM_PRINCIPAL(ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS)
values (1, 'root', 0, 1, 1, 0, SYSTIMESTAMP);

insert into SSM_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (1, 'System Root', '6367c48dd193d56ea7b0baad25b19455e529f5ee', 'rafizan.baharum@gmail.com', null);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID)
values(1, 0, 1, 1, 1);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS)
values(2, 1, 1, 1, 1, SYSTIMESTAMP);


-- SSMUSER1
insert into SSM_PRINCIPAL(ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS)
values (2, 'ssmuser1', 0, 1, 1, 0, SYSTIMESTAMP);

insert into SSM_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID)
values (2, 'SSM User 1', 'abc123', 'rafizan.baharum@gmail.com', null);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS)
values(3, 1, 2, 1, 1, SYSTIMESTAMP);




-- POSTGRESQL
-- ADMIN
insert into SSM_PRINCIPAL(ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (1, 'root', 0, true, 1, 0, CURRENT_TIMESTAMP);

insert into SSM_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID) values (1, 'System Root', '6367c48dd193d56ea7b0baad25b19455e529f5ee', 'rafizan.baharum@gmail.com', null);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID) values(1, 0, 1, 1, 1);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(2, 1, 1, 1, 1, CURRENT_TIMESTAMP);


-- SSMUSER1
insert into SSM_PRINCIPAL(ID, NAME, PRINCIPAL_TYPE, LOCKED, M_ST, C_ID, C_TS) values (2, 'ssmuser1', 0, true, 1, 0, CURRENT_TIMESTAMP);

insert into SSM_USER (ID, REALNAME, PASSWORD, EMAIL, ACTOR_ID) values (2, 'SSM User 1', 'abc123', 'rafizan.baharum@gmail.com', null);

insert into SSM_PRINCIPAL_ROLE (ID, ROLE_TYPE, PRINCIPAL_ID, M_ST, C_ID, C_TS) values(3, 1, 2, 1, 1, CURRENT_TIMESTAMP);


