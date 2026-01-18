-- User insertion
INSERT INTO users (user_id, name, role, email, created_at) VALUES
(1, 'Admin User', 'ADMIN', 'admin@workflowx.local', CURRENT_TIMESTAMP),
(2, 'Maintenance Manager', 'MANAGER', 'manager@workflowx.local', CURRENT_TIMESTAMP),
(3, 'Technician One', 'TECHNICIAN', 'tech1@workflowx.local', CURRENT_TIMESTAMP);

-- Asset Insertion
INSERT INTO assets (asset_id, name, type, location, asset_status, created_at, created_by_id) VALUES
(1, 'Generator A', 'GENERATOR', 'Plant 1', 'ACTIVE', CURRENT_TIMESTAMP, 1),
(2, 'Generator B', 'GENERATOR', 'Plant 2', 'IN_MAINTENANCE', CURRENT_TIMESTAMP, 1),
(3, 'HVAC Unit 01', 'HVAC', 'Building A', 'ACTIVE', CURRENT_TIMESTAMP, 2),
(4, 'HVAC Unit 02', 'HVAC', 'Building B', 'ACTIVE', CURRENT_TIMESTAMP, 2),
(5, 'Forklift 01', 'VEHICLE', 'Warehouse', 'ACTIVE', CURRENT_TIMESTAMP, 2),
(6, 'Forklift 02', 'VEHICLE', 'Warehouse', 'RETIRED', CURRENT_TIMESTAMP, 2),
(7, 'Server Rack 01', 'IT_EQUIPMENT', 'Data Center', 'ACTIVE', CURRENT_TIMESTAMP, 1),
(8, 'Server Rack 02', 'IT_EQUIPMENT', 'Data Center', 'IN_MAINTENANCE', CURRENT_TIMESTAMP, 1),
(9, 'Water Pump A', 'PUMP', 'Basement', 'ACTIVE', CURRENT_TIMESTAMP, 3),
(10, 'Water Pump B', 'PUMP', 'Basement', 'IN_MAINTENANCE', CURRENT_TIMESTAMP, 3);

