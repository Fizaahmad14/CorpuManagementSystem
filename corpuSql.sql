use corpu;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Admin_account;
DROP TABLE IF EXISTS Unit;
DROP TABLE IF EXISTS SessionalStaff;
DROP TABLE IF EXISTS Interested;

CREATE TABLE Admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE Admin_account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    password VARCHAR(50),
    FOREIGN KEY (id) REFERENCES Admin(id)
);

CREATE TABLE SessionalStaff (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE Availability(
	timeSlots varchar (50) Primary Key
);

CREATE TABLE Interested (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    qualification varchar(10),
    timeslot varchar(30),
    unitName varchar(30),
    preference varchar(30),
    FOREIGN KEY (unitName) REFERENCES Unit(name),
    FOREIGN KEY (timeslot) REFERENCES Availability(timeSlots)
);

CREATE TABLE Unit(
    name varchar(30) primary key
);

INSERT INTO Admin (name, email, password, phone)
VALUES
    ('John Doe', 'johndoe@example.com', 'mypassword', '1234567890'),
    ('Jane Smith', 'janesmith@example.com', 'anotherpassword', '9876543210'),
    ('David Johnson', 'davidjohnson@example.com', 'secretpassword', '5555555555'),
    ('Sarah Williams', 'sarahwilliams@example.com', 'password123', '1111111111'),
    ('Michael Brown', 'michaelbrown@example.com', 'adminpassword', '9999999999'),
    ('Emily Davis', 'emilydavis@example.com', 'mypassword123', '7777777777'),
    ('Robert Wilson', 'robertwilson@example.com', 'pass123word', '8888888888');

INSERT INTO Admin_account (email, password)
VALUES
    ('johndoe@example.com', 'mypassword'),
    ('janesmith@example.com', 'anotherpassword'),
    ('davidjohnson@example.com', 'secretpassword'),
    ('sarahwilliams@example.com', 'password123'),
    ('michaelbrown@example.com', 'adminpassword'),
    ('emilydavis@example.com', 'mypassword123'),
    ('robertwilson@example.com', 'pass123word');

INSERT INTO Unit (name)
VALUES
    ('Calculus'),
    ('Linear Algebra'),
    ('DLD'),
    ('AI'),
    ('CyberSecurity'),
    ('Algo'),
    ('SE'),
    ('PDC'),
    ('Nummerical');
    
INSERT INTO Availability (timeSlots)
VALUES
    ('Monday (10:00AM - 5:00PM)'),
    ('Tuesday (10:00AM - 5:00PM)'),
    ('Wednesday (10:00AM - 5:00PM)'),
    ('Thursday (10:00AM - 5:00PM)'),
    ('Friday (10:00AM - 5:00PM)'),
    ('Saturday (10:00AM - 5:00PM)'),
    ('Sunday (10:00AM - 5:00PM)'),
    ('Monday (6:00PM - 11:00PM)'),
    ('Tuesday (6:00PM - 11:00PM)'),
    ('Wednesday (6:00PM - 11:00PM)');

INSERT INTO Interested (name, email, qualification, timeslot, unitName, preference)
VALUES
    ('John Doe', 'johndoe@example.com', 'B.Tech', 'Monday (10:00AM - 5:00PM)', 'Calculus', 'BSCS'),
    ('Jane Smith', 'janesmith@example.com', 'M.Sc', 'Tuesday (10:00AM - 5:00PM)', 'Linear Algebra', 'BSSE'),
    ('David Johnson', 'davidjohnson@example.com', 'Ph.D', 'Friday (10:00AM - 5:00PM)', 'AI', 'BSEE'),
    ('Sarah Williams', 'sarahwilliams@example.com', 'B.A', 'Monday (6:00PM - 11:00PM)', 'CyberSecurity', 'MSCS');




SELECT * FROM Admin;
SELECT * FROM Admin_account;
SELECT * FROM Unit;
SELECT * FROM Interested;
-- delete from Interested where id>=5