-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2016-10-19 04:03:02.811

-- tables
-- Table: AtmosphericDatas
CREATE TABLE AtmosphericDatas (
    idAtmosphericData int  NOT NULL IDENTITY(0, 1),
    humidity decimal(4,2)  NOT NULL,
    preasure decimal(6,2)  NOT NULL,
    visibility decimal(4,2)  NOT NULL,
    CONSTRAINT AtmosphericDatas_pk PRIMARY KEY  (idAtmosphericData)
);

-- Table: Cities
CREATE TABLE Cities (
    idCity int  NOT NULL IDENTITY(0, 1),
    city varchar(30)  NOT NULL,
    idCountry int  NOT NULL,
    CONSTRAINT Cities_pk PRIMARY KEY  (idCity)
);

-- Table: Countries
CREATE TABLE Countries (
    idCountry int  NOT NULL IDENTITY(0, 1),
    country varchar(30)  NOT NULL,
    idRegion int  NOT NULL,
    CONSTRAINT Countries_pk PRIMARY KEY  (idCountry)
);

-- Table: Days
CREATE TABLE Days (
    idDay int  NOT NULL IDENTITY(0, 1),
    date varchar(30)  NOT NULL,
    idWeekDay int  NOT NULL,
    maxTemp int  NOT NULL,
    minTemp int  NOT NULL,
    idDescription int  NOT NULL,
    CONSTRAINT Days_pk PRIMARY KEY  (idDay)
);

-- Table: Descriptions
CREATE TABLE Descriptions (
    idDescription int  NOT NULL IDENTITY(0, 1),
    description varchar(50)  NOT NULL,
    CONSTRAINT Descriptions_pk PRIMARY KEY  (idDescription)
);

-- Table: ExtendedForecasts
CREATE TABLE ExtendedForecasts (
    idExtendedForecast int  NOT NULL IDENTITY(0, 1),
    idForecast int  NOT NULL,
    date varchar(30)  NOT NULL,
    weekDay varchar(20)  NOT NULL,
    maxTemp int  NOT NULL,
    minTemp int  NOT NULL,
    description varchar(50)  NOT NULL,
    CONSTRAINT ExtendedForecasts_pk PRIMARY KEY  (idExtendedForecast,idForecast)
);

-- Table: Forecasts
CREATE TABLE Forecasts (
    idForecast int  NOT NULL IDENTITY(0, 1),
    idCity int  NOT NULL,
    idDay int  NOT NULL,
    idAtmosphericData int  NOT NULL,
    idWindData int  NOT NULL,
    CONSTRAINT Forecasts_pk PRIMARY KEY  (idForecast)
);

-- Table: Regions
CREATE TABLE Regions (
    idRegion int  NOT NULL IDENTITY(0, 1),
    region varchar(30)  NOT NULL,
    CONSTRAINT Regions_pk PRIMARY KEY  (idRegion)
);

-- Table: WeekDays
CREATE TABLE WeekDays (
    idWeekDay int  NOT NULL IDENTITY(0, 1),
    weekDay varchar(20)  NOT NULL,
    CONSTRAINT WeekDays_pk PRIMARY KEY  (idWeekDay)
);

-- Table: WindDatas
CREATE TABLE WindDatas (
    idWindData int  NOT NULL IDENTITY(0, 1),
    speed decimal(5,2)  NOT NULL,
    direction decimal(4,2)  NOT NULL,
    CONSTRAINT WindDatas_pk PRIMARY KEY  (idWindData)
);

-- foreign keys
-- Reference: Cities_Countries (table: Cities)
ALTER TABLE Cities ADD CONSTRAINT Cities_Countries
    FOREIGN KEY (idCountry)
    REFERENCES Countries (idCountry);

-- Reference: Countries_Regions (table: Countries)
ALTER TABLE Countries ADD CONSTRAINT Countries_Regions
    FOREIGN KEY (idRegion)
    REFERENCES Regions (idRegion);

-- Reference: Days_Descrpitions (table: Days)
ALTER TABLE Days ADD CONSTRAINT Days_Descrpitions
    FOREIGN KEY (idDescription)
    REFERENCES Descriptions (idDescription);

-- Reference: Days_WeekDays (table: Days)
ALTER TABLE Days ADD CONSTRAINT Days_WeekDays
    FOREIGN KEY (idWeekDay)
    REFERENCES WeekDays (idWeekDay);

-- Reference: ExtendedForecasts_Forecasts (table: ExtendedForecasts)
ALTER TABLE ExtendedForecasts ADD CONSTRAINT ExtendedForecasts_Forecasts
    FOREIGN KEY (idForecast)
    REFERENCES Forecasts (idForecast);

-- Reference: Forecasts_AtmosphericDatas (table: Forecasts)
ALTER TABLE Forecasts ADD CONSTRAINT Forecasts_AtmosphericDatas
    FOREIGN KEY (idAtmosphericData)
    REFERENCES AtmosphericDatas (idAtmosphericData);

-- Reference: Forecasts_Cities (table: Forecasts)
ALTER TABLE Forecasts ADD CONSTRAINT Forecasts_Cities
    FOREIGN KEY (idCity)
    REFERENCES Cities (idCity);

-- Reference: Forecasts_Days (table: Forecasts)
ALTER TABLE Forecasts ADD CONSTRAINT Forecasts_Days
    FOREIGN KEY (idDay)
    REFERENCES Days (idDay);

-- Reference: Forecasts_WindDatas (table: Forecasts)
ALTER TABLE Forecasts ADD CONSTRAINT Forecasts_WindDatas
    FOREIGN KEY (idWindData)
    REFERENCES WindDatas (idWindData);

-- End of file.

