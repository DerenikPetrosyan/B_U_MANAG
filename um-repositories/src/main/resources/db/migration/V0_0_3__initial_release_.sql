-- set data roles

insert into t_roles (id, role_name,created,updated) values
('a8f58c2e-475d-469f-ae25-f611aea07c6d', 'ADMIN',localtimestamp,localtimestamp);

insert into t_roles (id, role_name,created,updated) values
  ('2ef58c2e-435d-469f-ae25-f6ddaea07c6d', 'BANK_USER',localtimestamp,localtimestamp);

insert into t_roles (id, role_name,created,updated) values
  ('d83ea94a-b821-470d-a41f-4bfcad60ad15', 'CUSTOMER',localtimestamp,localtimestamp);

-- crate Super Admin

insert into t_bank_user(id,name,surname,email,u_password,status,created, updated) values
    ('47027871-f9e0-40ba-9d34-79fe3f5f89cb','Super','Admin','admin@admin.com','4Bf_cad60ad15','ACTIVE',localtimestamp,localtimestamp);

-- add Super Admin role
insert into t_bank_users_roles(role_id,bank_user_id,created,updated) values
     ('a8f58c2e-475d-469f-ae25-f611aea07c6d','47027871-f9e0-40ba-9d34-79fe3f5f89cb',localtimestamp,localtimestamp) ;
insert into t_bank_users_roles(role_id,bank_user_id,created,updated) values
('2ef58c2e-435d-469f-ae25-f6ddaea07c6d','47027871-f9e0-40ba-9d34-79fe3f5f89cb',localtimestamp,localtimestamp) ;