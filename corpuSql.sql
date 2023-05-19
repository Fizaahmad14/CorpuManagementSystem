use corpu;
DROP TABLE IF EXISTS currentAdmin;
DROP TABLE IF EXISTS ps_account;
DROP TABLE IF EXISTS PermanentStaff;
DROP TABLE IF EXISTS Interested;
DROP TABLE IF EXISTS SessionalStaff;
DROP TABLE IF EXISTS Availability;
DROP TABLE IF EXISTS preferences;
DROP TABLE IF EXISTS Unit;



CREATE TABLE Availability(
	timeSlots varchar (50) Primary Key
);
CREATE TABLE Unit(
    name varchar(30) primary key
);
CREATE TABLE Preferences(
    name varchar(30) primary key
);
CREATE TABLE PermanentStaff (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
	phone VARCHAR(30),
    qualification varchar(10),
    timeslot varchar(30),
    unitName varchar(30),
    preference varchar(30),
    FOREIGN KEY (preference) REFERENCES preferences(name),
    FOREIGN KEY (unitName) REFERENCES Unit(name),
    FOREIGN KEY (timeslot) REFERENCES Availability(timeSlots)
);
CREATE TABLE Interested (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(30),
    qualification varchar(10),
    timeslot varchar(30),
    unitName varchar(30),
    preference varchar(30),
    FOREIGN KEY (preference) REFERENCES preferences(name),
    FOREIGN KEY (unitName) REFERENCES Unit(name),
    FOREIGN KEY (timeslot) REFERENCES Availability(timeSlots)
);
CREATE TABLE SessionalStaff (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
	phone VARCHAR(30),
    qualification varchar(10),
    timeslot varchar(30),
    unitName varchar(30),
    preference varchar(30),
    FOREIGN KEY (preference) REFERENCES preferences(name),
    FOREIGN KEY (unitName) REFERENCES Unit(name),
    FOREIGN KEY (timeslot) REFERENCES Availability(timeSlots)
);

CREATE TABLE ps_account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    password VARCHAR(50),
    FOREIGN KEY (id) REFERENCES PermanentStaff(id)
);
CREATE TABLE currentAdmin(
	id INT PRIMARY KEY AUTO_INCREMENT,
    ps_id INT,
    FOREIGN KEY (ps_id) REFERENCES ps_account(id)
);


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

INSERT INTO Preferences (name)
VALUES
    ('BSCS'),
    ('BSSE'),
    ('BSEE'),
    ('MSCS'),
    ('MSEE'),
    ('BSAI'),
    ('BSCYS'),
    ('MSCYS'),
    ('PhD');

INSERT INTO PermanentStaff (name, email, phone, qualification, timeslot, unitName, preference)
VALUES
    ('John Doe', 'johndoe@example.com', '1234567890', 'BSCS', 'Monday (10:00AM - 5:00PM)', 'Calculus', 'BSEE'),
    ('Jane Smith', 'janesmith@example.com', '9876543210', 'MSEE', 'Wednesday (6:00PM - 11:00PM)', 'AI', 'BSCS'),
    ('Alice Johnson', 'alicejohnson@example.com', '4567890123', 'BSSE', 'Friday (10:00AM - 5:00PM)', 'Linear Algebra', 'MSCS'),
    ('Bob Anderson', 'bobanderson@example.com', '7890123456', 'PhD', 'Tuesday (10:00AM - 5:00PM)', 'CyberSecurity', 'BSEE'),
    ('Sarah Williams', 'sarahwilliams@example.com', '0123456789', 'BSCYS', 'Saturday (10:00AM - 5:00PM)', 'Algo', 'MSCYS'),
    ('Michael Brown', 'michaelbrown@example.com', '2345678901', 'BSAI', 'Monday (6:00PM - 11:00PM)', 'DLD', 'BSSE'),
    ('Emily Davis', 'emilydavis@example.com', '5678901234', 'BSEE', 'Sunday (10:00AM - 5:00PM)', 'SE', 'BSCS'),
    ('David Taylor', 'davidtaylor@example.com', '8901234567', 'MSCYS', 'Wednesday (10:00AM - 5:00PM)', 'PDC', 'PhD'),
    ('Olivia Moore', 'oliviamoore@example.com', '9012345678', 'MSCS', 'Tuesday (6:00PM - 11:00PM)', 'Nummerical', 'BSAI'),
    ('Daniel Lee', 'daniellee@example.com', '3456789012', 'BSSE', 'Thursday (10:00AM - 5:00PM)', 'AI', 'MSEE');

INSERT INTO ps_account (email, password)
VALUES
    ('johndoe@example.com', 'password123'),
    ('janesmith@example.com', 'password456'),
    ('alicejohnson@example.com', 'password789'),
    ('bobanderson@example.com', 'passwordabc'),
    ('sarahwilliams@example.com', 'passworddef'),
    ('michaelbrown@example.com', 'passwordghi'),
    ('emilydavis@example.com', 'passwordjkl'),
    ('davidtaylor@example.com', 'passwordmno'),
    ('oliviamoore@example.com', 'passwordpqr'),
    ('daniellee@example.com', 'passwordstu');
    
INSERT INTO Interested (name, email, phone, qualification, timeslot, unitName, preference)
VALUES
('Sophia Johnson', 'sophiajohnson@example.com', '1234567890', 'BSCS', 'Monday (10:00AM - 5:00PM)', 'Calculus', 'BSCYS'),
    ('Henry Davis', 'henrydavis@example.com', '9876543210', 'BSSE', 'Tuesday (10:00AM - 5:00PM)', 'Calculus', 'MSCYS'),
    ('Emma Wilson', 'emmawilson@example.com', '4567890123', 'BSEE', 'Wednesday (10:00AM - 5:00PM)', 'Calculus', 'BSCS'),
    ('Oliver Smith', 'oliversmith@example.com', '7890123456', 'MSCS', 'Thursday (10:00AM - 5:00PM)', 'Calculus', 'MSCS'),
    ('Sophie Williams', 'sophiewilliams@example.com', '0123456789', 'BSCS', 'Friday (10:00AM - 5:00PM)', 'Calculus', 'BSAI'),
    ('Benjamin Johnson', 'benjaminjohnson@example.com', '2345678901', 'BSAI', 'Saturday (10:00AM - 5:00PM)', 'Calculus', 'BSCYS'),
    ('Olivia Taylor', 'oliviataylor@example.com', '5678901234', 'BSEE', 'Sunday (10:00AM - 5:00PM)', 'Calculus', 'BSEE'),
    ('William Brown', 'williambrown@example.com', '8901234567', 'MSCYS', 'Monday (6:00PM - 11:00PM)', 'Calculus', 'MSCS'),
    ('Sophie Davis', 'sophiedavis@example.com', '9012345678', 'MSCS', 'Tuesday (6:00PM - 11:00PM)', 'Calculus', 'BSSE'),
    ('Thomas Lee', 'thomaslee@example.com', '3456789012', 'BSSE', 'Wednesday (6:00PM - 11:00PM)', 'Calculus', 'PhD'),
	('John Smith', 'johnsmith@example.com', '1234567890', 'BSCS', 'Monday (10:00AM - 5:00PM)', 'Calculus', 'BSEE'),
    ('Jane Doe', 'janedoe@example.com', '9876543210', 'BSSE', 'Tuesday (10:00AM - 5:00PM)', 'Linear Algebra', 'MSCS'),
    ('Mike Johnson', 'mikejohnson@example.com', '4567890123', 'BSEE', 'Wednesday (10:00AM - 5:00PM)', 'Linear Algebra', 'BSEE'),
    ('Emily Brown', 'emilybrown@example.com', '7890123456', 'MSCS', 'Thursday (10:00AM - 5:00PM)', 'Linear Algebra', 'BSAI'),
    ('Sarah Williams', 'sarahwilliams@example.com', '0123456789', 'BSCS', 'Friday (10:00AM - 5:00PM)', 'Linear Algebra', 'BSCYS'),
    ('Michael Smith', 'michaelsmith@example.com', '2345678901', 'BSAI', 'Saturday (10:00AM - 5:00PM)', 'Linear Algebra', 'PhD'),
    ('Emma Johnson', 'emmajohnson@example.com', '5678901234', 'BSEE', 'Sunday (10:00AM - 5:00PM)', 'Linear Algebra', 'BSSE'),
    ('David Brown', 'davidbrown@example.com', '8901234567', 'MSCYS', 'Monday (6:00PM - 11:00PM)', 'Linear Algebra', 'MSCS'),
    ('Olivia Davis', 'oliviadavis@example.com', '9012345678', 'MSCS', 'Tuesday (6:00PM - 11:00PM)', 'Linear Algebra', 'MSEE'),
    ('Daniel Lee', 'daniellee@example.com', '3456789012', 'BSSE', 'Wednesday (6:00PM - 11:00PM)', 'CyberSecurity', 'BSCS'),
	('Jane Doe', 'janedoe@example.com', '9876543210', 'BSSE', 'Tuesday (10:00AM - 5:00PM)', 'CyberSecurity', 'MSCS'),
    ('Mike Johnson', 'mikejohnson@example.com', '4567890123', 'BSEE', 'Wednesday (10:00AM - 5:00PM)', 'CyberSecurity', 'BSEE'),
    ('Emily Brown', 'emilybrown@example.com', '7890123456', 'MSCS', 'Thursday (10:00AM - 5:00PM)', 'CyberSecurity', 'BSAI'),
    ('Sarah Williams', 'sarahwilliams@example.com', '0123456789', 'BSCS', 'Friday (10:00AM - 5:00PM)', 'CyberSecurity', 'BSCYS'),
    ('Michael Smith', 'michaelsmith@example.com', '2345678901', 'BSAI', 'Saturday (10:00AM - 5:00PM)', 'CyberSecurity', 'PhD'),
    ('Emma Johnson', 'emmajohnson@example.com', '5678901234', 'BSEE', 'Sunday (10:00AM - 5:00PM)', 'CyberSecurity', 'BSSE'),
    ('David Brown', 'davidbrown@example.com', '8901234567', 'MSCYS', 'Monday (6:00PM - 11:00PM)', 'CyberSecurity', 'MSCS'),
    ('Olivia Davis', 'oliviadavis@example.com', '9012345678', 'MSCS', 'Tuesday (6:00PM - 11:00PM)', 'CyberSecurity', 'MSEE'),
    ('Daniel Lee', 'daniellee@example.com', '3456789012', 'BSSE', 'Wednesday (6:00PM - 11:00PM)', 'CyberSecurity', 'BSCS'),
    ('Sophia Johnson', 'sophiajohnson@example.com', '1234567890', 'BSCS', 'Monday (10:00AM - 5:00PM)', 'Nummerical', 'BSCYS'),
    ('Henry Davis', 'henrydavis@example.com', '9876543210', 'BSSE', 'Tuesday (10:00AM - 5:00PM)', 'Nummerical', 'MSCYS'),
    ('Emma Wilson', 'emmawilson@example.com', '4567890123', 'BSEE', 'Wednesday (10:00AM - 5:00PM)', 'Nummerical', 'BSCS'),
    ('Oliver Smith', 'oliversmith@example.com', '7890123456', 'MSCS', 'Thursday (10:00AM - 5:00PM)', 'Nummerical', 'MSCS'),
    ('Sophie Williams', 'sophiewilliams@example.com', '0123456789', 'BSCS', 'Friday (10:00AM - 5:00PM)', 'Nummerical', 'BSAI'),
    ('Benjamin Johnson', 'benjaminjohnson@example.com', '2345678901', 'BSAI', 'Saturday (10:00AM - 5:00PM)', 'Nummerical', 'BSCYS'),
    ('Olivia Taylor', 'oliviataylor@example.com', '5678901234', 'BSEE', 'Sunday (10:00AM - 5:00PM)', 'Nummerical', 'BSEE'),
    ('William Brown', 'williambrown@example.com', '8901234567', 'MSCYS', 'Monday (6:00PM - 11:00PM)', 'Nummerical', 'MSCS'),
    ('Sophie Davis', 'sophiedavis@example.com', '9012345678', 'MSCS', 'Tuesday (6:00PM - 11:00PM)', 'Nummerical', 'BSSE'),
    ('Thomas Lee', 'thomaslee@example.com', '3456789012', 'BSSE', 'Wednesday (6:00PM - 11:00PM)', 'Nummerical', 'PhD'),
       ('Liam Johnson', 'liamjohnson@example.com', '6789012345', 'BSCS', 'Monday (10:00AM - 5:00PM)', 'PDC', 'BSEE'),
    ('Sophia Davis', 'sophiadavis@example.com', '8901234567', 'BSSE', 'Tuesday (10:00AM - 5:00PM)', 'Algo', 'MSCS'),
    ('Emma Brown', 'emmabrown@example.com', '2345678901', 'BSEE', 'Wednesday (10:00AM - 5:00PM)', 'SE', 'BSCS'),
    ('Oliver Taylor', 'olivertaylor@example.com', '3456789012', 'MSCS', 'Thursday (10:00AM - 5:00PM)', 'AI', 'MSCS'),
    ('Sophie Johnson', 'sophiejohnson@example.com', '4567890123', 'BSCS', 'Friday (10:00AM - 5:00PM)', 'DLD', 'BSAI');
    

-- DELETE FROM Interested where id>0;    
-- ALTER TABLE Interested AUTO_INCREMENT = 1;

-- DELETE FROM SessionalStaff where id>0;    
-- ALTER TABLE SessionalStaff AUTO_INCREMENT = 1;

SELECT ps_account.id, ps_account.email, ps_account.password FROM ps_account join currentAdmin on ps_account.id = currentAdmin.id; 
SELECT name FROM Unit;

select * from selectedPreference;
select * from currentAdmin;
SELECT * FROM ps_account;    
SELECT * FROM PermanentStaff;
SELECT * FROM Interested;
SELECT * FROM SessionalStaff;
SELECT * FROM Unit;
SELECT * FROM Availability;
