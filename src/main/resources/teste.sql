DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS users;

CREATE TABLE users ( id INT AUTO_INCREMENT PRIMARY KEY, first_name VARCHAR(250) NOT NULL, last_name VARCHAR(250) NOT NULL, career VARCHAR(250) DEFAULT NULL );
CREATE TABLE cards ( id INT AUTO_INCREMENT PRIMARY KEY,
                    type VARCHAR(100) NOT NULL,
                    category ENUM('CREDIT', 'DEBIT', 'BOTH') NOT NULL,
                    user_id int,
                    FOREIGN KEY (user_id) REFERENCES users(id));

INSERT INTO users (first_name, last_name, career) VALUES
('Cristiano', 'Last Name', 'Dev'),
('Jose', 'Silva', 'QA'),
('Francisco', 'Santos', 'P.O'),
('Helena', 'Lima', 'CTO'),
('Milena', 'Leite', 'CEO'),
('Bruna', 'Miranda', 'COO');

INSERT INTO cards (type, category, user_id) VALUES('teste', 'CREDIT', 1);