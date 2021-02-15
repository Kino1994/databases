-- hibernate_sequence definition

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- airport definition

CREATE TABLE `airport` (
  `id` bigint NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- plane definition

CREATE TABLE `plane` (
  `id` bigint NOT NULL,
  `flight_hours` int DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `tail_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- crew definition

CREATE TABLE `crew` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- flight definition

CREATE TABLE `flight` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `departure_time` datetime(6) DEFAULT NULL,
  `duration` double DEFAULT NULL,
  `arrival_id` bigint DEFAULT NULL,
  `departure_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpe5jkhsyl71o408sf4936fy3l` (`arrival_id`),
  KEY `FKaxqek9h4f7km4qg67twbx2go5` (`departure_id`),
  KEY `FK7p9fvp6d7uh9cgn47uet8a8nb` (`plane_id`),
  CONSTRAINT `FK7p9fvp6d7uh9cgn47uet8a8nb` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FKaxqek9h4f7km4qg67twbx2go5` FOREIGN KEY (`departure_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKpe5jkhsyl71o408sf4936fy3l` FOREIGN KEY (`arrival_id`) REFERENCES `airport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- crew_flight definition

CREATE TABLE `crew_flight` (
  `crew_id` bigint NOT NULL,
  `flight_id` bigint NOT NULL,
  PRIMARY KEY (`crew_id`,`flight_id`),
  KEY `FK81gm6l07kchyrgh480tmr5a21` (`flight_id`),
  CONSTRAINT `FK81gm6l07kchyrgh480tmr5a21` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FKj2cms2qaljf8uuyg77gdr6um` FOREIGN KEY (`crew_id`) REFERENCES `crew` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- mechanic definition

CREATE TABLE `mechanic` (
  `id` bigint NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `employed_since` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- overhaul definition

CREATE TABLE `overhaul` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `spent_hours` double DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `airport_id` bigint DEFAULT NULL,
  `mechanic_id` bigint DEFAULT NULL,
  `plane_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7spsq6vvs53evo06ujlni8st4` (`airport_id`),
  KEY `FKp1ip1jo0l1plb4bjhfekx2m73` (`mechanic_id`),
  KEY `FK4u9u5nq20cb1rcubjg5howiwt` (`plane_id`),
  CONSTRAINT `FK4u9u5nq20cb1rcubjg5howiwt` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`),
  CONSTRAINT `FK7spsq6vvs53evo06ujlni8st4` FOREIGN KEY (`airport_id`) REFERENCES `airport` (`id`),
  CONSTRAINT `FKp1ip1jo0l1plb4bjhfekx2m73` FOREIGN KEY (`mechanic_id`) REFERENCES `mechanic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- airport insert


INSERT INTO airport (id,city,code,country,name) VALUES
	 (11,'Madrid','MAD','España','Aeropuerto de Madrid-Barajas Adolfo Suárez'),
	 (12,'Barcelona','BCN','España','Aeropuerto de Josep Tarradellas Barcelona-El Prat'),
	 (13,'Londres','LHR','Reino Unido','Londres Heathrow Airport'),
	 (14,'París','CDG','Francia','París Charles de Gaulle Airport'),
	 (15,'Amsterdam','AMS','Países Bajos','Ámsterdam Airport Schiphol'),
	 (16,'Frankfurt','FRA','Alemania','Frankfurt Airport');


-- plane insert


INSERT INTO plane (id,flight_hours,manufacturer,model,tail_number) VALUES
	 (1,10000,'Airbus','A320','00001'),
	 (2,11000,'Airbus','A330','00002'),
	 (3,12000,'Airbus','A340','00003'),
	 (4,13000,'Airbus','A350','00004'),
	 (5,14000,'Airbus','A380','00005'),
	 (6,210000,'Boeing','737','00006'),
	 (7,220000,'Boeing','747','00007'),
	 (8,230000,'Boeing','757','00008'),
	 (9,240000,'Boeing','767','00009'),
	 (10,25000,'Boeing','777','00010');

	 
-- crew insert	 
	 

 INSERT INTO crew (id,code,name,surname,company,`position`) VALUES
	 (42,'00001','Joaquin','De Vicente','Iberia','commander'),
	 (43,'00002','Antonio','Vazquez','Iberia','co-pilot'),
	 (44,'00003','Lucas','Gonzalez','Iberia','flight attendant'),
	 (45,'00004','Patricia','Lopez','Air Europa','commander'),
	 (46,'00005','Maria','Perez','Air Europa','co-pilot'),
	 (47,'00006','Ana','Marquez','Air Europa','flight attendant'),
	 (48,'00007','Santiago','Candela','Air France','commander'),
	 (49,'00008','Javier','Brotons','Air France','co-pilot'),
	 (50,'00009','Santy','Lerma','Air France','flight attendant'),
	 (51,'00010','Carlos','Antono','British Airways','commander'),
	 (52,'00011','Lara','Tisner','British Airways','co-pilot'),
	 (53,'00012','Beatriz','Sosa','British Airways','flight attendant'),
	 (54,'00013','Miguel','Gomez','American Airlines','commander'),
	 (55,'00014','ALvaro','Silva','American Airlines','co-pilot'),
	 (56,'00015','Celia','Garvi','American Airlines','flight attendant');

	 
-- flight insert
	

INSERT INTO flight (id,code,company,departure_time,duration,arrival_id,departure_id,plane_id) VALUES
	 (17,'0000001','Iberia','2021-02-16 01:44:58.716000',1.0,12,11,1),
	 (18,'0000002','Air Europa','2021-02-16 03:08:18.716000',2.0,13,11,2),
	 (19,'0000003','Air France','2021-02-16 04:31:38.716000',3.0,14,11,3),
	 (20,'0000004','British Airways','2021-02-16 05:54:58.716000',4.0,15,11,4),
	 (21,'0000005','American Airlines','2021-02-16 07:18:18.716000',5.0,16,11,5),
	 (22,'0000006','Iberia','2021-02-16 08:41:38.716000',1.0,11,12,6),
	 (23,'0000007','Air Europa','2021-02-16 10:04:58.716000',2.0,13,12,7),
	 (24,'0000008','Air France','2021-02-16 11:28:18.716000',3.0,14,12,8),
	 (25,'0000009','British Airways','2021-02-16 12:51:38.716000',4.0,15,12,9),
	 (26,'0000010','American Airlines','2021-02-16 14:14:58.716000',5.0,16,12,10),	 
	 (27,'0000011','Iberia','2021-02-16 15:38:18.716000',1.0,11,13,1),
	 (28,'0000012','Air Europa','2021-02-16 17:01:38.716000',2.0,12,13,2),
	 (29,'0000013','Air France','2021-02-16 18:24:58.716000',3.0,14,13,3),
	 (30,'0000014','British Airways','2021-02-16 19:48:18.716000',4.0,15,13,4),
	 (31,'0000015','American Airlines','2021-02-16 21:11:38.716000',5.0,16,13,5),
	 (32,'0000016','Iberia','2021-02-16 22:34:58.716000',1.0,11,14,6),
	 (33,'0000017','Air Europa','2021-02-16 23:58:18.716000',2.0,12,14,7),
	 (34,'0000018','Air France','2021-02-17 01:21:38.716000',3.0,13,14,8),
	 (35,'0000019','British Airways','2021-02-16 01:44:58.716000',4.0,15,14,9),
	 (36,'0000020','American Airlines','2021-02-16 03:08:18.716000',5.0,16,14,10),
	 (37,'0000021','Iberia','2021-02-16 04:31:38.716000',1.0,11,15,1),
	 (38,'0000022','Air Europa','2021-02-16 05:54:58.716000',2.0,12,15,2),
	 (39,'0000023','Air France','2021-02-16 07:18:18.716000',3.0,13,15,3),
	 (40,'0000024','British Airways','2021-02-16 07:18:18.716000',4.0,14,15,4),
	 (41,'0000025','American Airlines','2021-02-16 08:41:38.716000',5.0,16,15,5);
	 
	 
-- crew_flight insert
	 
	 
INSERT INTO crew_flight (crew_id,flight_id) VALUES
	 (42,17),
	 (43,17),
	 (44,17),
	 (45,18),
	 (46,18),
	 (47,18),
	 (48,19),
	 (49,19),
	 (50,19),
	 (51,20),
	 (52,20),
	 (53,20),
	 (54,21),
	 (55,21),
	 (56,21),
	 (42,22),
	 (43,22),
	 (44,22),
	 (45,23),
	 (46,23),
	 (47,23),
	 (48,24),
	 (49,24),
	 (50,24),
	 (51,25),
	 (52,25),
	 (53,25),
	 (54,26),
	 (55,26),
	 (56,26),
	 (42,27),
	 (43,27),
	 (44,27),
	 (45,28),
	 (46,28),
	 (47,28),
	 (48,29),
	 (49,29),
	 (50,29),
	 (51,30),
	 (52,30),
	 (53,30),
	 (54,31),
	 (55,31),
	 (56,31),
	 (42,32),
	 (43,32),
	 (44,32),
	 (45,33),
	 (46,33),
	 (47,33),
	 (48,34),
	 (49,34),
	 (50,34),
	 (51,35),
	 (52,35),
	 (53,35),
	 (54,36),
	 (55,36),
	 (56,36),
	 (42,37),
	 (43,37),
	 (44,37),
	 (45,38),
	 (46,38),
	 (47,38),
	 (48,39),
	 (49,39),
	 (50,39),
	 (51,40),
	 (52,40),
	 (53,40),
	 (54,41),
	 (55,41),
	 (56,41);

	 
-- mechanic insert	 


INSERT INTO mechanic (id,code,name,surname,company,education,employed_since) VALUES
	 (57,'00016','Andres','Lopez','Iberia','PhD Aeronautical engineering',1972),
	 (58,'00017','Ruben','Blanco','Air Europa','Aeronautical engineering Degree',1976),
	 (59,'00018','Gabriel','Galindo','Air France','Mechanical engineering Degree',1982);


-- overhaul insert	 
	 

INSERT INTO overhaul (id,description,end_date,spent_hours,start_date,`type`,airport_id,mechanic_id,plane_id) VALUES
	 (60,'Everything is ok','2021-02-16 01:44:59.858000',2.0,'2021-02-16 01:44:58.716000','periodical',12,57,1),
	 (61,'Wheel brakes seem loose','2021-02-16 04:31:39.858000',5.0,'2021-02-16 01:44:58.716000','reparation',13,58,2),
	 (62,'Everything seems ok','2021-02-16 07:18:19.858000',3.0,'2021-02-16 01:44:58.716000','periodical',14,59,3),
	 (63,'Left Wing is damaged','2021-02-16 10:04:59.858000',7.0,'2021-02-16 01:44:58.716000','reparation',11,57,6),
	 (64,'No overhauls found','2021-02-16 12:51:39.858000',1.0,'2021-02-16 01:44:58.716000','periodical',13,58,7),
	 (65,'Engine is damage','2021-02-16 15:38:19.858000',9.0,'2021-02-16 01:44:58.716000','reparation',14,58,8);
	 

-- sequence insert	 

	 
INSERT INTO test.hibernate_sequence (next_val) VALUES (66);
	 
	 

