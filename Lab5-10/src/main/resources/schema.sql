CREATE TABLE household (     eircode VARCHAR(8) PRIMARY KEY,
                             number_of_occupants INT NOT NULL,
                             max_number_of_occupants INT NOT NULL,
                             owner_occupied BIT NOT NULL,
                             number_of_pets INT
);

CREATE TABLE pets (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      animal_type VARCHAR(255) NOT NULL,
                      breed VARCHAR(255) NOT NULL,
                      age INT NOT NULL,
                      household_eircode VARCHAR(8) NOT NULL,
                      CONSTRAINT fk_household FOREIGN KEY (household_eircode) REFERENCES household(eircode)
                          ON DELETE CASCADE
                          ON UPDATE CASCADE
);




CREATE TABLE `users` (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         username VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL,
                         role VARCHAR(255) NOT NULL,
                         locked BOOLEAN NOT NULL DEFAULT false,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         county VARCHAR(255)
);
