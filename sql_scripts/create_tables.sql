-- Creates Ping_Data Table
CREATE TABLE IF NOT EXISTS Ping_Data (
	ping_id serial PRIMARY KEY,
	epc VARCHAR(24) NOT NULL,
	logical_device VARCHAR(255) NOT NULL,
	base_logical_device VARCHAR(255) NOT NULL,
	rssi FLOAT NOT NULL,
	timeUTC BIGINT NOT NULL,
	latitude DECIMAL(9,6) NOT NULL,
	longitude DECIMAL(9,6) NOT NULL,
	antenna_num INT NOT NULL
);

-- Creates Tool Table
CREATE TABLE IF NOT EXISTS Tool (
	tool_id serial PRIMARY KEY,
	tool_name VARCHAR(50) NOT NULL,
	epc VARCHAR(24) NOT NULL UNIQUE,
	antenna_last_ping INT NOT NULL,
	antenna_2nd_last_ping INT,
	antenna_3nd_last_ping INT,
	
	FOREIGN KEY (antenna_last_ping) REFERENCES Ping_Data (ping_id) ON DELETE CASCADE,
	FOREIGN KEY (antenna_2nd_last_ping) REFERENCES Ping_Data (ping_id) ON DELETE CASCADE,
	FOREIGN KEY (antenna_3nd_last_ping) REFERENCES Ping_Data (ping_id) ON DELETE CASCADE
);

-- DROP statements to delete tables for testing
-- DROP TABLE Ping_Data Cascade;
-- DROP TABLE Tool Cascade;