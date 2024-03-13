--liquibase formatted sql

--changeset mokrychin-ve:20230223-7 failOnError:true
--comment: Add to patients table references from doctors.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:1 select count(*) from information_schema.tables where table_name = 'patients';

ALTER TABLE patients
    ADD COLUMN doctor_id BIGINT,
    ADD CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors(id);