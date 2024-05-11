insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (1, 'Andrzej', 'Panda', '513000123', 'andrzej.panda@yopmail.com', '000001', 'OCULIST');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (2, 'Stefan', 'Panda', '512000001', 'stefan.panda@yopmail.com', '000002', 'GP');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (3, 'Hanna', 'Fortel', '556042102', 'hanna.fortel@yopmail.com', '000003', 'DERMATOLOGIST');
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (4, 'Filip', 'Tasak', '660440220', 'filip.tasak@yopmail.com', '000004', 'SURGEON');

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, weight)
values (1, 'Jan', 'Nowak', '510102111', 'jan.nowak@yopmail.com', '000001', '1990-10-10', 76.2);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, weight)
values (2, 'Krzysztof', 'Drób', '523102134', 'krzysztof.drob@yopmail.com', '000002', '1972-12-01', 101.5);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, weight)
values (3, 'Aurelia', 'Panda', '302120423', 'aurelia.panda@yopmail.com', '000003', '1991-04-12', 50.6);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, weight)
values (4, 'Zbigniew', 'Panda', '669440222', 'zbigniew.panda@yopmail.com', '000004', '1990-11-21', 80.4);
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, weight)
values (5, 'Dariusz', 'Panda', '403202111', 'dariusz.panda@yopmail.com', '000005', '1972-10-15', 87.4);

insert into visit (id, description, time, doctor_id, patient_id)
values (1, 'wizyta okulistyczna #1', '2024-04-17', 1, 1);
insert into visit (id, description, time, doctor_id, patient_id)
values (2, 'wizyta #1', '2024-04-19', 2, 2);
insert into visit (id, description, time, doctor_id, patient_id)
values (3, 'okulista', '2024-04-19', 2, 3);
insert into visit (id, description, time, doctor_id, patient_id)
values (4, 'lekarz rodzinny', '2024-04-19', 2, 3);
insert into visit (id, description, time, doctor_id, patient_id)
values (5, 'dermatologia', '2024-04-19', 3, 3);
insert into visit (id, description, time, doctor_id, patient_id)
values (6, 'chirurgia', '2024-04-19', 4, 5);

insert into medical_treatment (id, description, type, visit_id)
values (1, 'Pani jest lekko ślepa', 'VISION', 3);
insert into medical_treatment (id, description, type, visit_id)
values (2, 'USG jamy brzusznej', 'USG', 4);
insert into medical_treatment (id, description, type, visit_id)
values (3, 'RTG klatki piersiowej', 'RTG', 4);
insert into medical_treatment (id, description, type, visit_id)
values (4, 'przepisanie leków na łuszczyce', 'SKIN_CARE', 5);
insert into medical_treatment (id, description, type, visit_id)
values (5, 'wycięcie wrastającego paznokcia', 'SURGERY', 6);
insert into medical_treatment (id, description, type, visit_id)
values (6, 'wycięcie wyrostka', 'SURGERY', 6);
insert into medical_treatment (id, description, type, visit_id)
values (7, 'wycięcie czegoś tam', 'SURGERY', 6);
