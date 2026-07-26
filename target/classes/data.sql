-- Ensure the 'patient' table exists
CREATE TABLE IF NOT EXISTS patient
(
   ID            UUID PRIMARY KEY,
    name            VARCHAR(255)        NOT NULL,
    email           VARCHAR(255) UNIQUE NOT NULL,
    address         VARCHAR(255)        NOT NULL,
     dob   DATE                NOT NULL,
    registeredDate DATE                NOT NULL
    );

-- Insert well-known UUIDs for specific patients
INSERT INTO patient (id, name, email, address, dob, registeredDate)
SELECT '123e4567-e89b-12d3-a456-426614174000',
       'John Doe',
       'john.doe@example.com',
       '123 Main St, Springfield',
       '1985-06-15',
       '2024-01-10'
    WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174000');

INSERT INTO patient (id, name, email, address, dob, registeredDate)
SELECT '123e4567-e89b-12d3-a456-426614174001',
       'Jane Smith',
       'jane.smith@example.com',
       '456 Elm St, Shelbyville',
       '1990-09-23',
       '2023-12-01'
    WHERE NOT EXISTS (SELECT 1
                  FROM patient
                  WHERE id = '123e4567-e89b-12d3-a456-426614174001');

