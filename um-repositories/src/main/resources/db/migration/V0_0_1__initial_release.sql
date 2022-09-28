create table t_bank_user
(
  id                   uuid primary key,

  name                 varchar(25) not null,
  surname              varchar(25) not null,
  email                varchar(25) not null,
  u_password           varchar(25) not null,
  gender               varchar(25) not null,
  status               varchar(25) not null,
  dob                  timestamp,
  reset_password_token varchar(25),
  address_id           uuid,
  created              timestamp   not null,
  updated              timestamp   not null,
  deleted              timestamp,

  constraint uk_email_deleted unique (email, deleted)
);

create table t_costomer_user
(
  id                   uuid primary key,

  name                 varchar(25) not null,
  surname              varchar(25) not null,
  email                varchar(25) not null,
  u_password           varchar(25) not null,
  gender               varchar(25) not null,
  status               varchar(25) not null,
  dob                  timestamp,
  reset_password_token varchar(25),
  address_id           uuid,
  created              timestamp   not null,
  updated              timestamp   not null,
  deleted              timestamp,

  constraint uk_email_deleted2 unique (email, deleted)
);

create table t_roles
(
  id        uuid primary key,
  role_name varchar(25) not null,

  created              timestamp   not null,
  updated              timestamp   not null,
  deleted              timestamp

);

create table privilege
(
  id   uuid primary key,

  name varchar(100) not null

);

CREATE TABLE roles_privileges
(
  role_id      uuid,
  privilege_id uuid,
  CONSTRAINT fks_role1_id FOREIGN KEY (role_id) REFERENCES t_roles (id),
  CONSTRAINT fks_privilege2_id FOREIGN KEY (privilege_id) REFERENCES privilege (id)

);

CREATE TABLE t_costomer_users_roles
(
  role_id          uuid,
  costomer_user_id uuid,
  created              timestamp   not null,
  updated              timestamp   not null,
  deleted              timestamp,

  CONSTRAINT fk1_role3_id FOREIGN KEY (role_id) REFERENCES t_roles (id),
  CONSTRAINT fk24_costomer_user_id FOREIGN KEY (costomer_user_id) REFERENCES t_costomer_user (id)

);

CREATE TABLE t_bank_users_roles
(
  role_id      uuid,
  bank_user_id uuid,
  created              timestamp   not null default localtimestamp ,
  updated              timestamp   not null default localtimestamp,
  deleted              timestamp,
  CONSTRAINT fk2_role5_id FOREIGN KEY (role_id) REFERENCES t_roles (id),
  CONSTRAINT fk16_bank_user_id FOREIGN KEY (bank_user_id) REFERENCES t_bank_user (id)

);

create table t_country
(
  id      uuid primary key,
  country varchar(255) not null
);

create table t_state
(
  id         uuid primary key,
  state      varchar(255) not null,
  country_id uuid         not null,

  CONSTRAINT fk2_country2_id FOREIGN KEY (country_id) REFERENCES t_country (id)
);

create table t_city
(
  id         uuid primary key,
  city      varchar(255) not null,
  country_id uuid         not null,
  state_id   uuid         not null,

  CONSTRAINT fk3_country3_id FOREIGN KEY (country_id) REFERENCES t_country (id),
  CONSTRAINT fk3_state3_id FOREIGN KEY (state_id) REFERENCES t_state (id)
);

create table t_address
(
  id         uuid primary key,

  country_id uuid         not null,
  state_id   uuid         not null,
  city_id    uuid,
  zip_code   varchar(10),
  address    varchar(255) not null,
  created    timestamp    not null,
  updated    timestamp    not null,
  deleted    timestamp,

  CONSTRAINT fk1_country1_id FOREIGN KEY (country_id) REFERENCES t_country (id),
  CONSTRAINT fk1_state1_id FOREIGN KEY (state_id) REFERENCES t_state (id),
  CONSTRAINT fk1_city_id FOREIGN KEY (city_id) REFERENCES t_city (id)

);