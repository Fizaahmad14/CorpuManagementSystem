use corpu;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Admin_account;
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

SELECT * FROM Admin;
SELECT * FROM Admin_account;