--liquibase formatted sql

--changeset mokrychin-ve:20230223-2 failOnError:true
--comment: Create patients table.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:0 select count(*) from information_schema.tables where table_name = 'patients';
CREATE TABLE IF NOT EXISTS patients (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    age         INTEGER
);