CREATE OR REPLACE TRIGGER trg_check_quantity
BEFORE INSERT OR UPDATE ON product_proj
FOR EACH ROW
DECLARE
    v_quantity NUMBER;
BEGIN
    
    v_quantity := :NEW.QUANTITY;

    IF v_quantity < 10 THEN
       
        RAISE_APPLICATION_ERROR(-20001, 'Quantity is less than ten');
    END IF;
END;
/




CREATE OR REPLACE TRIGGER check_duplicate_id
BEFORE INSERT ON dealer_proj
FOR EACH ROW
DECLARE
    v_count NUMBER;
BEGIN
    
    SELECT COUNT(*) INTO v_count
    FROM dealer_proj
    WHERE ID = :NEW.ID;

    IF v_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Duplicate ID is not allowed.');
    END IF;
END;
/









CREATE OR REPLACE FUNCTION calculate_inventory_value RETURN NUMBER IS
    total_value NUMBER := 0;
BEGIN
    SELECT SUM(PRICE * QUANTITY) INTO total_value
    FROM product_proj;
    
    RETURN total_value;
END;
/




CREATE OR REPLACE PROCEDURE insert_dealer(
    p_dealer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_city IN VARCHAR2,
    p_gender IN VARCHAR2
) AS
BEGIN
    INSERT INTO dealer_proj (ID, NAME, CITY, GENDER)
    VALUES (p_dealer_id, p_name, p_city, p_gender);
    
    COMMIT; -- Commit the transaction
END insert_dealer;
/
