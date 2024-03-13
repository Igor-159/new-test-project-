--liquibase formatted sql

--changeset mokrychin-ve:20230223-4 failOnError:true
--comment: Create doctors table.
--preconditions onFail:MARK_RAN onError:HALT
--precondition-sql-check expectedResult:1 select count(*) from information_schema.tables where table_name = 'doctors';
--precondition-sql-check expectedResult:1 select count(*) from information_schema.tables where table_name = 'patients';

CREATE TABLE IF NOT EXISTS doctor_patient (
      doctor_id BIGINT NOT NULL,
      patient_id BIGINT NOT NULL,
      PRIMARY KEY (doctor_id, patient_id),
      FOREIGN KEY (doctor_id) REFERENCES doctors(id),
      FOREIGN KEY (patient_id) REFERENCES patients(id)
    );