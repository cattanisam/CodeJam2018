CREATE TABLE `CurrentFires` (
    `CurrentFireID` int(11) NOT NULL AUTO_INCREMENT,
    `Latitude` float(20) DEFAULT NULL,
    `Longitude` float(20) DEFAULT NULL, 
    `Brightness` float(20) DEFAULT NULL,
    `Scan` float(20) DEFAULT NULL, 
    `Track` float(20) DEFAULT NULL, 
    `ACG_Date` varchar(45) DEFAULT NULL, 
    `ACG_Time` varchar(45) DEFAULT NULL, 
    `Satellite` varchar(45) DEFAULT NULL,
    `Confidence` float(20) DEFAULT NULL,
    `Version` varchar(45) DEFAULT NULL, 
    `Bright_T31` float(20) DEFAULT NULL, 
    `FRP` float(20) DEFAULT NULL, 
    `DayNight` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`CurrentFireID`),
    UNIQUE KEY `CurrentFireID_UNIQUE` (`CurrentFireID`)
    );

CREATE TABLE `TwoDaysAgoFires` (
    `TwoDaysAgoFireID` int(11) NOT NULL AUTO_INCREMENT,
    `Latitude` float(20) DEFAULT NULL,
    `Longitude` float(20) DEFAULT NULL, 
    `Brightness` float(20) DEFAULT NULL,
    `Scan` float(20) DEFAULT NULL, 
    `Track` float(20) DEFAULT NULL, 
    `ACG_Date` varchar(45) DEFAULT NULL, 
    `ACG_Time` varchar(45) DEFAULT NULL, 
    `Satellite` varchar(45) DEFAULT NULL,
    `Confidence` float(20) DEFAULT NULL,
    `Version` varchar(45) DEFAULT NULL, 
    `Bright_T31` float(20) DEFAULT NULL, 
    `FRP` float(20) DEFAULT NULL, 
    `DayNight` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`TwoDaysAgoFireID`),
    UNIQUE KEY `TwoDaysAgoFireID_UNIQUE` (`TwoDaysAgoFireID`)
    );

insert into TwoDaysAgoFires (Latitude, Longitude, Brightness, Scan, Track,ACG_Date, ACG_Time, Satellite, Confidence, Version, Bright_T31, FRP, DayNight) values