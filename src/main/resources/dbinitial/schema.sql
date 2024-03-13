CREATE TABLE IF NOT EXISTS hospitals
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    address VARCHAR(50) NOT NULL
    );


CREATE TABLE IF NOT EXISTS patients
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INTEGER NOT NULL
    );

ALTER TABLE patients
    ADD COLUMN doctor_id INTEGER REFERENCES doctors(id);


CREATE TABLE IF NOT EXISTS doctors
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL ,
    last_name VARCHAR(50) NOT NULL,
    profile VARCHAR(50) NOT NULL,
    patients_id INTEGER,
    hospital_id INTEGER
    );

ALTER TABLE doctors
ADD CONSTRAINT fk_patient_id FOREIGN KEY (patients_id) REFERENCES patients(id);

ALTER TABLE doctors
    ADD CONSTRAINT fk_hospital_id FOREIGN KEY (hospital_id) REFERENCES hospitals(id);

ALTER TABLE doctors
ALTER COLUMN patient_id TYPE BIGINT;

ALTER TABLE doctors
ALTER COLUMN hospital_id TYPE BIGINT;

ALTER TABLE patients
ADD COLUMN hospital_id BIGINT;

ALTER TABLE patients
ADD CONSTRAINT fk_hospital_id FOREIGN KEY (hospital_id) REFERENCES hospitals(id);

ALTER TABLE patients
ALTER COLUMN  doctor_id TYPE BIGINT;

ALTER TABLE hospitals
ADD COLUMN doctor_id BIGINT;
ALTER TABLE hospitals
ADD CONSTRAINT fk_doctor_id FOREIGN KEY (doctor_id) REFERENCES doctors(id);

ALTER TABLE doctors DROP COLUMN patient_id;

CREATE TABLE IF NOT EXISTS doctor_patient
(
    doctor_id BIGINT,
    patient_id BIGINT,
    PRIMARY KEY (doctor_id, patient_id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id),
    FOREIGN KEY (patient_id) REFERENCES patients(id)
)