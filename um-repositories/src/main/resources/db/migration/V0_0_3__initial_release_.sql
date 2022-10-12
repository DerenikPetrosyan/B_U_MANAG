-- set  roles
insert into t_roles (id, role_name,created,updated) values
('a8f58c2e-475d-469f-ae25-f611aea07c6d', 'ADMIN',localtimestamp,localtimestamp);

insert into t_roles (id, role_name,created,updated) values
  ('2ef58c2e-435d-469f-ae25-f6ddaea07c6d', 'BANKUSER',localtimestamp,localtimestamp);

insert into t_roles (id, role_name,created,updated) values
  ('d83ea94a-b821-470d-a41f-4bfcad60ad15', 'CUSTOMER',localtimestamp,localtimestamp);
insert into t_roles (id, role_name,created,updated) values
('2e461a94-8b4e-46b3-8766-25580ed77cbb', 'VIPCUSTOMER',localtimestamp,localtimestamp);

-- set permissions
--
-- insert into privilege(id,name) values('a57a580a-18f7-4314-a77c-757d58bcbfa0', 'can_create_customer'),
--                                      ('7d367675-35a0-49bc-80ad-5e3a305f6061', 'can_update_customer'),
--                                      ('aaf8a69e-694f-4d52-bdb2-214c5603667d',''),
--                                      ('616f71e1-904e-4fd4-bf91-d75ab5e048ca',''),
--                                      ('68be0d31-e381-4923-b386-6164a3c4c2bd',''),
--                                      ('0b5c2214-634a-4a06-8a69-c34c14329f05',''),
--                                      ('aea500f6-d617-412c-98d3-9925d29a3404',''),
--                                      ('67ae1ca5-8a7b-4bc9-858a-a61849693756',''),
--                                      ('3adc5896-fd8f-468c-8baa-baff0f3832df',''),
--                                      ('30a871b8-1b1f-4f90-b111-77cbc06b87b8',''),
--                                      ('8bff3b7d-1e04-4203-ac96-65d610bb05b8',''),
--                                      ('756b831e-26a5-4f91-be71-4f1cf3c05e1e',''),
--                                      ('c376719d-f5a7-49e6-9885-c17f36c96930',''),
--                                      ('44953c0e-6359-4471-a7d1-f245eb6d77c2',''),
--                                      ('c4a640f9-6c5d-4a65-8a1d-f567fe544e5a',''),
--                                      ('4d6a0116-7d9c-4a8e-8ccb-21472b33215f',''),
--                                      ('b4a5133e-633a-4182-b837-cb985a330c4a',''),
--                                      ('0f077b7a-d691-4563-aaa5-2601cbaab63b',''),
--                                      ('d597edc7-be85-47c5-acc4-b4731b1d8b8e',''),
--                                      ('b0e278d7-b4a0-4f31-a795-59dc78126436',''),
--                                      ('50413cb9-74c5-4ed7-b802-91caae6c8771','');

-- set  Super Admin

insert into t_bank_user(id,name,surname,email,u_password,status,created, updated) values
    ('47027871-f9e0-40ba-9d34-79fe3f5f89cb','Super','Admin','admin@admin.com','cGFzc3dvcmQ=','ACTIVE',localtimestamp,localtimestamp);

-- add Super Admin role
insert into t_bank_users_roles(role_id,bank_user_id,created,updated) values
     ('a8f58c2e-475d-469f-ae25-f611aea07c6d','47027871-f9e0-40ba-9d34-79fe3f5f89cb',localtimestamp,localtimestamp) ;
insert into t_bank_users_roles(role_id,bank_user_id,created,updated) values
('2ef58c2e-435d-469f-ae25-f6ddaea07c6d','47027871-f9e0-40ba-9d34-79fe3f5f89cb',localtimestamp,localtimestamp) ;