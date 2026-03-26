CREATE DATABASE IF NOT EXISTS aerofly;
USE aerofly;

CREATE TABLE IF NOT EXISTS flights (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       flight_number VARCHAR(10) NOT NULL UNIQUE,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departure_time VARCHAR(50) NOT NULL
    );

CREATE TABLE IF NOT EXISTS bookings (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        flight_id INT NOT NULL,
                                        passenger_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (flight_id) REFERENCES flights(id) ON DELETE CASCADE
    );

INSERT INTO flights (flight_number, origin, destination, departure_time) VALUES
                                                                             ('AF101', 'Santiago (SCL)', 'Buenos Aires (EZE)', '08:30 AM'),
                                                                             ('AF102', 'Santiago (SCL)', 'Lima (LIM)', '10:15 AM'),
                                                                             ('AF103', 'Santiago (SCL)', 'Bogotá (BOG)', '01:45 PM'),
                                                                             ('AF104', 'Santiago (SCL)', 'Madrid (MAD)', '07:00 PM'),
                                                                             ('AF201', 'Lima (LIM)', 'Cuzco (CUZ)', '06:00 AM'),
                                                                             ('AF202', 'Lima (LIM)', 'Santiago (SCL)', '03:20 PM'),
                                                                             ('AF203', 'Lima (LIM)', 'Miami (MIA)', '11:50 PM'),
                                                                             ('AF301', 'Madrid (MAD)', 'Barcelona (BCN)', '09:00 AM'),
                                                                             ('AF302', 'Madrid (MAD)', 'Paris (CDG)', '12:30 PM'),
                                                                             ('AF303', 'Madrid (MAD)', 'London (LHR)', '04:15 PM'),
                                                                             ('AF401', 'New York (JFK)', 'Los Angeles (LAX)', '10:00 AM'),
                                                                             ('AF402', 'New York (JFK)', 'London (LHR)', '08:30 PM'),
                                                                             ('AF501', 'Tokyo (NRT)', 'Seoul (ICN)', '11:20 AM'),
                                                                             ('AF502', 'Tokyo (NRT)', 'Sydney (SYD)', '09:45 PM'),
                                                                             ('AF601', 'Buenos Aires (EZE)', 'Rio de Janeiro (GIG)', '02:00 PM'),
                                                                             ('AF602', 'Buenos Aires (EZE)', 'Santiago (SCL)', '05:30 PM');

INSERT INTO bookings (flight_id, passenger_name, email) VALUES
                                                            (1, 'John Doe', 'john.doe@example.com'),
                                                            (4, 'Jane Smith', 'jane.smith@test.com'),
                                                            (6, 'Carlos Ortega', 'c.ortega@mail.cl');