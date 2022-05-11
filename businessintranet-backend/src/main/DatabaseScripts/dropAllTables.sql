SELECT concat('DROP TABLE IF EXISTS `', table_name, '`;')
FROM information_schema.tables
WHERE table_schema = 'businessintranetdb';

DROP TABLE IF EXISTS `accounts_email_groups`;
DROP TABLE IF EXISTS `accounts`;
DROP TABLE IF EXISTS `departments`;
DROP TABLE IF EXISTS `employees_email_groups`;
DROP TABLE IF EXISTS `messages`;
DROP TABLE IF EXISTS `employees`;
DROP TABLE IF EXISTS `hibernate_sequence`;