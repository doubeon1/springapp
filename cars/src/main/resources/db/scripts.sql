-- cars
CREATE TABLE cars ( 
   ID 			  BIGINT AUTO_INCREMENT,
   VIN			  VARCHAR(17) NOT NULL, 
   MODEL 		  VARCHAR(200), 
   REG_NUM 		  VARCHAR(8)  NOT NULL,
   PURCHASED	  DATE,
   INIT_KM  DECIMAL(10,2),
   PRIMARY KEY (ID)
);
ALTER TABLE cars ADD CONSTRAINT VIN_UK UNIQUE(VIN);

-- refueling
CREATE TABLE refueling ( 
   ID 			  BIGINT AUTO_INCREMENT,
   REF_DATE		  TIMESTAMP		NOT NULL,
   PRICE 		  DECIMAL(10,2) NOT NULL,
   AMOUNT 	  	  DECIMAL(10,2) NOT NULL,
   KM		 	  DECIMAL(10,2) NOT NULL,
   CAR_ID		  BIGINT 		NOT NULL,
   LOCATION		  VARCHAR(100),
   FUEL		  	  VARCHAR(50),
   PRIMARY KEY (ID),
   FOREIGN KEY (CAR_ID) REFERENCES cars (ID)
);

INSERT INTO cars (ID,VIN, MODEL, REG_NUM, PURCHASED, INIT_KM) values (1, '12345678901234ABC', 'Skoda Fabia 1.2 HTP', '3H20698', PARSEDATETIME('26.7.2016','dd.MM.yyyy','cz'), 45695);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('26.7.2018, 15:15:58','dd.MM.yyyy, hh:mm:ss','cz'), 28.10, 30, 46000, 1);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('28.7.2018, 08:15:58','dd.MM.yyyy, hh:mm:ss','cz'), 29.50, 30, 46420, 1);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('01.8.2018, 11:15:58','dd.MM.yyyy, hh:mm:ss','cz'), 28.90, 30, 47001, 1);

INSERT INTO cars (ID, VIN, MODEL, REG_NUM, PURCHASED, INIT_KM) values (2, 'AX456', 'Trabant 601 Deluxe', 'PIRAT001', PARSEDATETIME('26.7.2018','dd.MM.yyyy','cz'), 1695);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('1.8.2018, 09:32:58','dd.MM.yyyy, hh:mm:ss','cz'), 15.20, 20, 1705, 2);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('8.9.2018, 08:00:01','dd.MM.yyyy, hh:mm:ss','cz'), 16.30, 16, 1710, 2);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('21.11.2018, 11:00:00','dd.MM.yyyy, hh:mm:ss','cz'), 14.90, 15, 1730, 2);

INSERT INTO cars (ID, VIN, MODEL, REG_NUM, PURCHASED, INIT_KM) values (3, 'AB123', 'Lada 2101', 'JCA1284', PARSEDATETIME('26.7.1980','dd.MM.yyyy','cz'), 56951);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('5.10.2018, 19:32:58','dd.MM.yyyy, hh:mm:ss','cz'), 14.20, 17.5, 56958, 3);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('12.11.2018, 07:02:01','dd.MM.yyyy, hh:mm:ss','cz'), 21.30, 13, 56970, 3);
INSERT INTO refueling (REF_DATE, PRICE, AMOUNT, KM, CAR_ID) values (PARSEDATETIME('21.01.2019, 10:30:00','dd.MM.yyyy, hh:mm:ss','cz'), 15.90, 11, 56993, 3);