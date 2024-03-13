--liquibase formatted sql

--changeset mokrychin-ve:20230223-5 failOnError:true
--comment: Add to doctors table references from hospital.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:1 select count(*) from information_schema.tables where table_name = 'doctors';
ALTER TABLE doctors
    ADD COLUMN hospital_id BIGINT,
    ADD CONSTRAINT fk_hospital_id FOREIGN KEY (hospital_id) REFERENCES hospitals(id);
