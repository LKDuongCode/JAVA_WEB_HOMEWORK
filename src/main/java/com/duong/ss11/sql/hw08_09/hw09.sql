use ss11;

DELIMITER //

CREATE PROCEDURE sp_update_category(
    IN p_id INT,
    IN p_name VARCHAR(255)
)
BEGIN
    UPDATE category
    SET name = p_name
    WHERE id = p_id;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE sp_delete_category(
    IN p_id INT
)
BEGIN
    DELETE FROM category WHERE id = p_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE sp_get_category_by_id(
    IN p_id INT
)
BEGIN
    SELECT * FROM category WHERE id = p_id;
END //

DELIMITER ;

