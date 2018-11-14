DROP DATABASE IF EXISTS thedocs;
CREATE DATABASE IF NOT EXISTS thedocs;
USE thedocs;


DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
	pat_id INTEGER AUTO_INCREMENT ,
	firstName VARCHAR(15) NOT NULL,
	lastName VARCHAR(20) NOT NULL,
	address1 VARCHAR(20) NOT NULL,
	address2 VARCHAR(20),
	town VARCHAR(20),
	contactNo VARCHAR(15) NOT NULL,
	dateOfBirth DATE NOT NULL,
	gender VARCHAR(1) NOT NULL,
	PRIMARY KEY(pat_id) );

INSERT INTO patients VALUES ( null, 'Amy', 'Kenny', 'long Road', 'Brideswell', 'Athlone', '08712345678', '2010-12-21', 'F');
INSERT INTO patients VALUES ( null, 'Ciara', 'Kelly', '65 oldtown','Retreat', 'Athlone','085345323', '2011-04-19', 'F');
INSERT INTO patients VALUES ( null, 'Emma', 'Fallon', 'Arcadia',null, 'Athlone', '0878998766', '1982-04-30', 'F');
INSERT INTO patients VALUES ( null, 'Anita', 'Adams', 'Whitepark','Curraghboy', 'Athlone', '085987654321', '1992-12-12', 'F');
INSERT INTO patients VALUES ( null, 'Jim', 'Jones', 'Main St',null, 'Roscommon', '0877897897', '1990-12-25', 'M');
INSERT INTO patients VALUES ( null, 'Colm', 'Cummins', 'Cam', 'Curry', 'Brideswell', '0876534276', '1998-02-14', 'M');
INSERT INTO patients VALUES ( null, 'Le', 'Dolan', 'Whitepark','Curraghboy', 'Galway', '0859191919', '1992-05-20', 'M');
INSERT INTO patients VALUES ( null, 'Eoghan', 'Nolan', 'Main St',null, 'Cork', '0876767677', '1990-11-25', 'M');
INSERT INTO patients VALUES ( null, 'Oran', 'Fox', 'Cam', 'Curry', 'Kildare', '0876544561', '2008-02-14', 'M');


SELECT * FROM patients;


DROP TABLE IF EXISTS doctors;

CREATE TABLE doctors (

	doc_id INTEGER AUTO_INCREMENT ,
	firstName VARCHAR(15) NOT NULL,
	lastName VARCHAR(20) NOT NULL,
	speciality VARCHAR(20) NOT NULL,
	contactNo VARCHAR(15) NOT NULL,
	dateOfBirth DATE NOT NULL,
	gender VARCHAR(1) NOT NULL,
	PRIMARY KEY(doc_id) );

INSERT INTO doctors VALUES ( null, 'Tom', 'Beades', 'GP', '0876534276', '1978-02-14', 'M');
INSERT INTO doctors VALUES ( null, 'Dan', 'Barry', 'Audiologist','0858945861', '1989-03-12', 'M');
INSERT INTO doctors VALUES ( null, 'Fiona', 'Dolan',  'dermatologist', '0839012543', '1965-04-11', 'F');
INSERT INTO doctors VALUES ( null, 'Lily', 'Burke', 'GP','0853456723', '1969-03-12', 'F');
INSERT INTO doctors VALUES ( null, 'Frank', 'Reynolds',  'paediatrician', '0876598897', '1965-04-11', 'M');


SELECT * FROM doctors;

DROP TABLE IF EXISTS drugs;

CREATE TABLE drugs (
	drug_id INTEGER AUTO_INCREMENT ,
	drug_name VARCHAR (20),
	cost FLOAT(7, 2) NOT NULL,
	PRIMARY KEY(drug_id) );

INSERT INTO drugs VALUES ( null, 'Panadol', 2.95 );
INSERT INTO drugs VALUES ( null, 'penicillin', 4.50);
INSERT INTO drugs VALUES ( null, 'calpol', 4.30);
INSERT INTO drugs VALUES ( null, 'earex drops',5.00);
INSERT INTO drugs VALUES ( null, 'optrex eye spray', 3.00);
INSERT INTO drugs VALUES ( null, 'Vit C', 5.99);

SELECT * FROM drugs;


DROP TABLE IF EXISTS prescriptions;

CREATE TABLE prescriptions (
	prescription_id INTEGER AUTO_INCREMENT,
	date_perscribed DATE NOT NULL,
	dosage VARCHAR(25),
	pat_id INTEGER NOT NULL,
	drug_id INTEGER NOT NULL,
	doc_id INTEGER NOT NULL,
	PRIMARY KEY(prescription_id),
	FOREIGN KEY (pat_id) REFERENCES patients (pat_id),
	FOREIGN KEY (drug_id) REFERENCES drugs (drug_id),
	FOREIGN KEY (doc_id) REFERENCES doctors (doc_id)
 );

INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 1,3,5 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 2,3,5 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 9,3,5 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 2,1,2 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 1,4,1 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 8,4,2 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 8,4,2 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 9,2,1 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 6,2,4 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 2,4,2 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 4,5,1 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 5,3,3 );
INSERT INTO prescriptions VALUES ( null, '2012-07-01', '500mg', 7,5,1 );
INSERT INTO prescriptions VALUES ( null, '2012-08-01', '100mg', 6,1,5 );

SELECT * FROM prescriptions;
