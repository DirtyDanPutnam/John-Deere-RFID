-- NOTES: If we get extra info it will be easier to have sample data
-- Do we have to consider a new tool or will it be added even before it gets pinged?
-- If Question above is true then it would make me have to check if:
-- new ping's epc exists
-- if not create tool with that info then update (maybe better to do in java)
-- if so then just update

-- This trigger shifts the pings down on a tool and deletes the third known ping
DELIMITER //

CREATE TRIGGER Update_Tool_Pings
BEFORE INSERT ON Ping_Data
FOR EACH ROW
BEGIN
    DECLARE tool_id_match INT;
	DECLARE third_last_ping_id INT;
	
    -- Find the tool_id that matches the new ping's epc
    SELECT tool_id INTO tool_id_match
    FROM Tool
    WHERE epc = NEW.epc

    -- If a matching tool is found, get third ping ID and update only that tool's ping history
    IF tool_id_match IS NOT NULL THEN
		-- Get the third last ping ID before updating
        SELECT antenna_3rd_last_ping INTO third_last_ping_id
        FROM Tool
        WHERE tool_id = tool_id_match;
		-- Update tool ping history
        UPDATE Tool
        SET 
            antenna_3rd_last_ping = antenna_2nd_last_ping,
            antenna_2nd_last_ping = antenna_last_ping,
            antenna_last_ping = NEW.ping_id 
        WHERE tool_id = tool_id_match;

		-- Delete the third last ping from the pings table if it exists
        IF third_last_ping_id IS NOT NULL THEN
            DELETE FROM Ping_Data WHERE ping_id = third_last_ping_id;
        END IF;
    END IF;
END;
//

-- Show triggers command for testing
-- SHOW TRIGGERS;

-- Drop command for testing
-- DROP TRIGGER IF EXISTS Update_Tool_Pings;
