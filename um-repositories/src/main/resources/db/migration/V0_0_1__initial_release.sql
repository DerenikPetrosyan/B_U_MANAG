create table t_users
(
    id uuid primary key,

    name varchar(25) not null,

    email varchar(25) not null
--
--     created timestamp  current_timestamp not null ,
--     updated timestamp  current_timestamp not null ,
--     deleted timestamp,
--
--     constraint uk_email_deleted unique (email, deleted)
)
