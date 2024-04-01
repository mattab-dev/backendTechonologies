insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (1, 'Andrzej', 'Panda', '513000123', 'andrzej.panda@yopmail.com', '000001', 'OCULIST');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (2, 'Stefan', 'Panda', '512000001', 'stefan.panda@yopmail.com', '000002', 'GP');
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
values (1, 'Jan', 'Nowak', '510102111', 'jan.nowak@yopmail.com', '000001', '1990-10-10');
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
values (2, 'Krzysztof', 'Drób', '523102134', 'krzysztof.drob@yopmail.com', '000002', '1972-12-01');
insert into visit (id, description, time, doctor_id, patient_id)
values (1, 'wizyta okulistyczna #1', '2024-04-17', 1, 1);
insert into visit (id, description, time, doctor_id, patient_id)
values (2, 'wizyta #1', '2024-04-19', 2, 2);
