use ss11;

DELIMITER $$

CREATE PROCEDURE sp_insert_category(
    IN p_name VARCHAR(50)
)
BEGIN
    INSERT INTO category (name, status)
    VALUES (p_name, 'ACTIVE');
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_check_category_exists(
    IN p_name VARCHAR(50)
)
BEGIN
SELECT * FROM category WHERE name = p_name;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE sp_get_all_categories()
BEGIN
    SELECT * FROM category;
END $$

DELIMITER ;

