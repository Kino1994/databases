-- JSON crew_members definition


ALTER TABLE flight
ADD crew_members JSON NOT NULL;


-- JSON crew_members insert


UPDATE flight SET crew_members = '[42,43,44]' WHERE id = 17;
UPDATE flight SET crew_members = '[45,46,47]' WHERE id = 18;
UPDATE flight SET crew_members = '[48,49,50]' WHERE id = 19;
UPDATE flight SET crew_members = '[51,52,53]' WHERE id = 20;
UPDATE flight SET crew_members = '[54,55,56]' WHERE id = 21;
UPDATE flight SET crew_members = '[42,43,44]' WHERE id = 22;
UPDATE flight SET crew_members = '[45,46,47]' WHERE id = 23;
UPDATE flight SET crew_members = '[48,49,50]' WHERE id = 24;
UPDATE flight SET crew_members = '[51,52,53]' WHERE id = 25;
UPDATE flight SET crew_members = '[54,55,56]' WHERE id = 26;
UPDATE flight SET crew_members = '[42,43,44]' WHERE id = 27;
UPDATE flight SET crew_members = '[45,46,47]' WHERE id = 28;
UPDATE flight SET crew_members = '[48,49,50]' WHERE id = 29;
UPDATE flight SET crew_members = '[51,52,53]' WHERE id = 30;
UPDATE flight SET crew_members = '[54,55,56]' WHERE id = 31;
UPDATE flight SET crew_members = '[42,43,44]' WHERE id = 32;
UPDATE flight SET crew_members = '[45,46,47]' WHERE id = 33;
UPDATE flight SET crew_members = '[48,49,50]' WHERE id = 34;
UPDATE flight SET crew_members = '[51,52,53]' WHERE id = 35;
UPDATE flight SET crew_members = '[54,55,56]' WHERE id = 36;
UPDATE flight SET crew_members = '[42,43,44]' WHERE id = 37;
UPDATE flight SET crew_members = '[45,46,47]' WHERE id = 38;
UPDATE flight SET crew_members = '[48,49,50]' WHERE id = 39;
UPDATE flight SET crew_members = '[51,52,53]' WHERE id = 40;
UPDATE flight SET crew_members = '[54,55,56]' WHERE id = 41;


-- JSON overhauls definition


ALTER TABLE plane
ADD overhauls JSON NULL;


UPDATE plane SET overhauls = '{"start_date":"2021-02-16 01:44:59.858000","end_date":"2021-02-16 01:44:58.716000","description":"Everything is ok","spent_hours":2.0,"type":"periodical","airport_id":12,"mechanic_id":57}' WHERE id = 1;
UPDATE plane SET overhauls = '{"start_date":"2021-02-16 04:31:39.858000","end_date":"2021-02-16 01:44:58.716000","description":"Wheel brakes seem loose","spent_hours":5.0,"type":"reparation","airport_id":13,"mechanic_id":58}' WHERE id = 2;
UPDATE plane SET overhauls = '{"start_date":"2021-02-16 07:18:19.858000","end_date":"2021-02-16 01:44:58.716000","description":"Everything seems ok","spent_hours":3.0,"type":"periodical","airport_id":14,"mechanic_id":59}' WHERE id = 3;
UPDATE plane SET overhauls = '{"start_date":"2021-02-16 10:04:59.858000","end_date":"2021-02-16 01:44:58.716000","description":"Left Wing is damaged","spent_hours":7.0,"type":"reparation","airport_id":11,"mechanic_id":57}' WHERE id = 6;
UPDATE plane SET overhauls = '{"start_date":"2021-02-16 12:51:39.858000","end_date":"2021-02-16 01:44:58.716000","description":"No overhauls found","spent_hours":1.0,"type":"periodical","airport_id":13,"mechanic_id":58}' WHERE id = 7;
UPDATE plane SET overhauls = '{"start_date":"2021-02-16 15:38:19.858000","end_date":"2021-02-16 01:44:58.716000","description":"Engine is damage","spent_hours":9.0,"type":"reparation","airport_id":14,"mechanic_id":58}' WHERE id = 8;







