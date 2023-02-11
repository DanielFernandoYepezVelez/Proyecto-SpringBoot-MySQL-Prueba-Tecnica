/* CLIENTS */
INSERT INTO `clients` (dni, name, birth_date, address, city) VALUES ('101721012', 'Daniel Yepez', '2023-07-12', 'Calle 55 # 22-45', 'Medellin');
INSERT INTO `clients` (dni, name, birth_date, address, city) VALUES ('111561011', 'Harvy Garcia', '2022-08-23', 'Transversal 21 # 12-13', 'Barranquilla');
INSERT INTO `clients` (dni, name, birth_date, address, city) VALUES ('001421414', 'Camilo Guzman', '2018-09-14', 'Carrera 55 # 10-21', 'Cali');
INSERT INTO `clients` (dni, name, birth_date, address, city) VALUES ('101021415', 'Dona Bustamante', '2019-02-18', 'Avenida 55 # 23-90', 'Rionegro');


/* CARS */
INSERT INTO `cars` (registration_number, model, inspection) VALUES ('123-ABCD', '2017', 1);
INSERT INTO `cars` (registration_number, model, inspection) VALUES ('456-JKL', '2018', 1);
INSERT INTO `cars` (registration_number, model, inspection) VALUES ('321-PQL', '2015', 0);
INSERT INTO `cars` (registration_number, model, inspection) VALUES ('567-ITL', '2021', 0);

/* POLICIES */
INSERT INTO `insurance_policies` (number_policy, plane_name, coverage, max_value, filing_date, client_dni, registration_number) VALUES ('123-TJK00', 'Seguridad Vial', 'Siniestro Vial', 3000, '2022-02-22', '101721012', '123-ABCD');
INSERT INTO `insurance_policies` (number_policy, plane_name, coverage, max_value, filing_date, client_dni, registration_number) VALUES ('598-LMG00', 'Seguridad Auto', 'Robo O Hurto', 9000, '2023-02-12', '111561011', '456-JKL');
INSERT INTO `insurance_policies` (number_policy, plane_name, coverage, max_value, filing_date, client_dni, registration_number) VALUES ('234-PLN00', 'Mantenimiento Auto', 'Mantenimiento', 15000, '2015-03-16', '001421414', '321-PQL');
INSERT INTO `insurance_policies` (number_policy, plane_name, coverage, max_value, filing_date, client_dni, registration_number) VALUES ('821-VGH00', 'Renovación Auto', 'Renovación', 11000, '2019-08-29', '101021415', '567-ITL');