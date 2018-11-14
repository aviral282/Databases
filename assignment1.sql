#1  Write an SQL query to show how many days you have been alive 
SELECT DATEDIFF('2017-06-25', '1996-08-18')as 'days alive';


#2 	Update Doctor Lily Burke’s lastName to a lastName of  your choice
Update  doctors set lastName = 'trivedi' where firstName='Lily' ;
select * from doctors;


#3 What is the name and price of the most expensive drug in the drugs table?
select drug_name, max(cost) as "price" from drugs;


#4 What is the name of the least expensive drug in the drugs table?
select drug_name, min(cost) as " min cost" from drugs;


#5 Select the patients who have no address2 details stored in thedoc patients table
select * from patients where address2 is null;


#6 Choose 1 of these patients and update their details to
#   store an address2 in thedoc patients table. 
update patients set address2 = 'croi oige' where pat_id=3;
select * from patients;


#7 	What is the average cost of a drug in the drugs table?
select avg(cost) as 'averageCost' from drugs;


#8  Count the different specialties of thedoc surgery  
select speciality, count(*) from doctors group by speciality;   #


#9 List the different specialities of thedoc
#  surgery displaying the specialities in UPPERCASE letters.
select distinct Upper(speciality) from doctors ;


#10 How many prescriptions did the paediatrician write?
select count(*) as "total_prescription" from prescriptions where doc_id in ( select doc_id from doctors where doc_id = 5); #nested

##10 How many prescriptions did the paediatrician write?
select count(*) as "total_prescription" from prescriptions inner join doctors on prescriptions.doc_id = doctors.doc_id #join
where doctors.speciality = 'paediatrician';



#11 What are the names of the doctors who wrote the prescriptions for patient 6
select firstName,lastName  from doctors inner join  prescriptions on doctors.doc_id = prescriptions.doc_id #join
where prescriptions.pat_id = 6;
#or
select firstName,lastName  from doctors where doc_id in ( select doc_id from prescriptions where pat_id = 6);


#12 List the firstName, lastName of all the patients who had no prescription written for them
select firstName,lastName from patients left join prescriptions on    #left join
patients.pat_id = prescriptions.pat_id where prescriptions.drug_id is null;


#13 Insert any drug of your choice into the drugs table 
#   List all the drugs in the drugs table – verifying your drug was added
INSERT INTO drugs (drug_id, drug_name, cost) VALUES ('7', 'thoraxx', '4.88');
select * from drugs;


#14 Now list all drugs that have been prescribed by the Doctors – your drug should not appear in the list
select distinct drug_name from drugs inner join prescriptions on
drugs.drug_id = prescriptions.drug_id;


#15 Add an attribute “Manufacturer” to the drugs tables.  
ALTER TABLE drugs ADD COLUMN Manufacturer VARCHAR(45) NULL;
select * from drugs;


#16 	Update the drugs tables to record the manufacturer of Panadol and Calpol as GlaxoSmithKline. 
update drugs set Manufacturer='GlaxoSmithKline' where drug_name = 'Panadol' or drug_name ='Calpol ';
select * from drugs;


