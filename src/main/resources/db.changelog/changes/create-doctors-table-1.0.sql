--liquibase formatted sql

--changeset mokrychin-ve:20230223-3 failOnError:true
--comment: Create doctors table.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_name = 'doctors';
CREATE TABLE IF NOT EXISTS doctors (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    profile     VARCHAR(50) NOT NULL
);
