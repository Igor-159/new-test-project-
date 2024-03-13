--liquibase formatted sql

--changeset mokrychin-ve:20230223-1 failOnError:true
--comment: Create hospitals table.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_name = 'hospitals';
CREATE TABLE IF NOT EXISTS hospitals (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL UNIQUE,
    address     VARCHAR(50) NOT NULL
    );