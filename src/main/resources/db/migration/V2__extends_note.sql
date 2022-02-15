ALTER TABLE note ADD COLUMN deadline timestamp;
ALTER TABLE note ADD COLUMN checked boolean default false;