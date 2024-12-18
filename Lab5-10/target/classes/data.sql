INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('A94B6F3', 3, 5, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('D02XY45', 3, 5, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('T12AB34', 2, 4, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('C15DE67', 5, 7, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('F12GH89', 1, 2, 0, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('B78IJ01', 3, 5, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('M34KL56', 4, 6, 0, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('P90QR78', 2, 4, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('V23ST01', 5, 7, 1, 1);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('X45UV67', 1, 2, 0, 0);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('Y67WX89', 3, 5, 1, 0);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('Z01YZ23', 4, 6, 0, 0);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('Q45AB78', 2, 4, 1, 0);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('R67CD01', 5, 7, 1, 0);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied, number_of_pets)
VALUES ('S23EF45', 1, 2, 0, 0);





INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Buddy', 'Dog', 'Golden Retriever', 3, 'A94B6F3');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Charlie', 'Dog', 'Beagle', 4, 'D02XY45');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Whiskers', 'Cat', 'Persian', 5, 'T12AB34');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Coco', 'Rabbit', 'Holland Lop', 1, 'C15DE67');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Goldie', 'Fish', 'Goldfish', 1, 'F12GH89');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Polly', 'Bird', 'Parakeet', 2, 'B78IJ01');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Max', 'Dog', 'German Shepherd', 5, 'M34KL56');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Luna', 'Cat', 'Maine Coon', 3, 'P90QR78');
INSERT INTO pets (name, animal_type, breed, age, household_eircode)
VALUES ('Nibbles', 'Hamster', 'Syrian Hamster', 1, 'V23ST01');




INSERT INTO users (username, password, role, locked, first_name, last_name, county)
VALUES ('testuser', '$2a$10$DowDJmND/pZG3uWNOF.XIe6O3dIHAnAv8srmTKK.DfyVHy2OWCeHu', 'ROLE_USER', false, 'John', 'Doe', 'SampleCounty');
