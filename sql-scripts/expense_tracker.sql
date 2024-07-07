CREATE DATABASE  IF NOT EXISTS `expense_tracker`;
USE `expense_tracker`;

--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `expense`;

CREATE TABLE expense
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    expense_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    amount DOUBLE(5, 2) NOT NULL,
    category VARCHAR(255) NOT NULL,
    date DATE NOT NULL
);

--
-- Data for table `employee`
--
INSERT INTO expense(expense_name, description, amount, category, date)
VALUES("Water bill", "water bill", 600.00, "Bills", "2021-10-14");

INSERT INTO expense(expense_name, description, amount, category, date)
VALUES("Electricity bill", "electricity bill", 900.00, "Bills", "2021-10-13");