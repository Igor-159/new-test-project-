--liquibase formatted sql

--changeset mokrychin-ve:20230223-8 failOnError:true
--comment: Add to patients table references from hospitals.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:1 select count(*) from information_schema.tables where table_name = 'patients';

ALTER TABLE patients
    ADD COLUMN hospital_id BIGINT,
    ADD CONSTRAINT fk_hospital_id FOREIGN KEY (hospital_id) REFERENCES hospitals(id);