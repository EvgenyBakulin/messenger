-- liquibase formatted sql

--changeset bakulin:1

ALTER TABLE users ADD CONSTRAINT uniq_name UNIQUE (username);

CREATE TABLE IF NOT EXISTS authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    FOREIGN KEY (username)
    REFERENCES users (username)
    );
create unique index IF NOT EXISTS ix_auth_username on authorities (username,authority);