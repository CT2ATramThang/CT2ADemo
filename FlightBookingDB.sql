drop database if exists FlightBookingDB;
create database FlightBookingDB;

use FlightBookingDB;

create table Customer(
	customerId 			int 	primary key 	auto_increment,
    customerFirstName	varchar(50) 	,
    customerLastName	varchar(50) 	,
    customerAddress		varchar(50)		,
    customerBirthdate	date			,
    email				varchar(50)		,
    phone				varchar(50)		
);

insert into Customer(customerFirstName,customerLastName, customerAddress, customerBirthdate, email, phone)
Value 	('Davison',' Michelle', 'Washington', '2000-01-01', 'Michelle@gmail.com', '123456789'),
		('Mayteh',' Kendall', 'Washington', '2001-01-01', 'Kendall@gmail.com', '987654321'),
		('Onandonga',' Bruce', 'Los Angeles', '1960-01-01', 'Michelle@gmail.com', '123456789'),
		('Antavius',' Anthony', 'Sacramento', '1970-01-01', 'Kendall@gmail.com', '987654321'),
		('Bradlee',' Danny', 'San Francisco', '1980-01-01', 'Michelle@gmail.com', '123456789'),
		('Suscipe',' Reynaldo', 'Fresno', '1990-01-01', 'Kendall@gmail.com', '987654321'),
		('Sullivan',' Geraldine', 'San Diego', '1975-01-01', 'Michelle@gmail.com', '123456789'),
		('Bucket',' Charles', 'Mission Viejo', '2017-01-01', 'Kendall@gmail.com', '987654321');

create table CreditCard(
	creditCardId 		int		primary key		auto_increment,
    accountNumber		char(16)		,
    accountName 		varchar(50)		,
    releasesDate 		date			,
    securityCode		char(3)		,
    cardAmount 			double			
	
);

insert into CreditCard(accountNumber, accountName, releasesDate, securityCode, cardAmount)
Value	('1234567890123456', 'Davison Michelle', '2015-01-01', 000, 10000),
		('1234567891234567', 'Mayteh Kendall', '2015-05-01', 123, 20000),
		('1234567896543210', 'Onandonga Bruce', '2016-01-01', 456, 30000),
		('1234567890147258', 'Antavius Anthony', '2016-06-06', 789, 40000),
		('1234567899876543', 'Bradlee Danny', '2017-08-01', 147, 50000),
		('1234567895426531', 'Suscipe Reynaldo', '2018-01-01', 258, 60000),
		('1234567899872589', 'Sullivan Geraldine', '2018-01-31', 568, 70000),
		('1234567890159514', 'Bucket Charles', '2019-01-01', 080, 80000);

create table Booking(
	bookingId 			int 	primary key		auto_increment,
    codeBooking			varchar(50)			,
    dateBooking			date				,
    
    customerId  		int					,
	constraint cus_fk_booking foreign key(customerId )
    REFERENCES Customer(customerId ) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into Booking(codeBooking, dateBooking, customerId)
Value	('000001', '2019-01-01', 1),
		('000002', '2019-02-01', 2),
		('000003', '2019-03-01', 3),
		('000004', '2019-04-01', 4),
		('000005', '2019-05-01', 5),
		('000006', '2019-06-01', 6),
		('000007', '2019-07-01', 7),
		('000008', '2019-08-01', 8);
        
create table Payment(
	transactionId		int		primary key 	auto_increment,
    transactionDate		date	,
    description 		varchar(50),
    transactionAmount	double	,
    creditCardId 		int		,
    bookingId 			int		,
	constraint tran_fk_account foreign key(creditCardId)
    REFERENCES CreditCard(creditCardId ) ON UPDATE SET NULL ON DELETE SET NULL,
	constraint tran_fk_booking foreign key(bookingId)
    REFERENCES Booking(bookingId ) ON UPDATE SET NULL ON DELETE SET NULL
    
); 

insert into Payment(transactionDate, description, transactionAmount, creditCardId, bookingId)
Value	('2019-01-01', null, 605, 1, 1);
		

create table TicketType(
	ticketTypeId		int 	primary key		auto_increment,
    type				varchar(50)		,
    exchangeRate			double			
);

insert into TicketType(ticketTypeId, type, exchangeRate)
Value	(1, 'Adults', 1),
		(2, 'Children', 0.5),
		(3, 'Infants', 0.25);

create table TicketClass(
	ticketClassId		int 	primary key		auto_increment,
    typeClass			varchar(50)		,
    exchangeRateClass		double		
);

insert into	TicketClass(ticketClassId, typeClass, exchangeRateClass)
Value	(1, 'economy', 1),
		(2, 'business', 1.5);

create table Country(
	countryId 			int 	primary key,
	countryName		 	varchar(50),
    countryCode			varchar(50)
);

insert into Country(countryId, countryName, countryCode)
Value	(1, 'VietNam', 'VN'),
		(2, 'America', 'AMR'),
		(3, 'Japan', 'JP'),
		(4, 'Thailand', 'TL'),
		(5, 'Korea', 'KR'),
		(6, 'China', 'CN'),
		(7, 'Indonesia', 'ID'),
		(8, 'Myanmar', 'MYA'),
		(9, 'Singapore', 'SGA'),
		(10, 'Campuchia', 'CAM');

create table AirPortStation(
	AirPortStationId	int		primary key		auto_increment,
    airportName				varchar(50)		,
    countryId 				int				,
    constraint airportstation_fk_air foreign key(countryId)
    REFERENCES Country(countryId) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into AirPortStation(airportName, countryId)
Value	('Tân Sơn Nhất(HN)', 1),
		('DaNang(DN)', 1),
		('Nội Bài(HCM)', 1),
		('John F. Kennedy', 2),
		('Newark-(EWR)', 2),
		('LaGuardia (LGA)', 2),
		('Osaka International Airport', 3),
		('Haneda Airport', 3),
		('Kansai International Airport', 3),
		('Chubu Centrair International Airport', 3),
		('Narita International Airport', 3);
        
create table FlightRoute(
	flightRouteId		int		primary key		auto_increment,
	flightRouteFrom		int		,
    flightRouteTo		int		,
    standPrice			double	,
    distance			double,
    duration			int				,
    constraint flight_fk_from foreign key(flightRouteFrom)
    REFERENCES AirPortStation(AirPortStationId) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint flight_fk_to foreign key(flightRouteTo)
    REFERENCES AirPortStation(AirPortStationId) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into FlightRoute(flightRouteFrom, flightRouteTo, standPrice, distance, duration)
Value	(1, 2, 605, 400, 135),
		(2, 1, 850, 400, 135),
		(1, 3, 725, 500, 75),
		(3, 1, 562, 500, 75),
		(1, 4, 693, 600, 200),
		(3, 5, 789, 700, 120),
		(1, 6, 968, 800, 135),
		(1, 7, 630, 900, 210);

create table Aircraft(
	aircraftId			int		primary key		auto_increment,
    airNumber			varchar(50)		,
    numberOfCommercialSeats		int		,
    numberOfVIP					int		
);

insert into Aircraft(aircraftId, airNumber, numberOfCommercialSeats, numberOfVIP)
Value	(1, 'Boin787', 30, 20),
		(2, 'Boin545', 30, 20),
		(3, 'Phonex666', 35, 25),
		(4, 'Phonex547', 40, 20),
		(5, 'Magic123', 40, 20),
		(6, 'Magic963', 45, 20),
		(7, 'Bright2712', 50, 20),
		(8, 'Win-Metawin2102', 50, 20);
      
create table Promotion(
	promotionId			int 	primary key		auto_increment,
    promotionName		varchar(50)		,
    description			varchar(255),
    valueOfPromotion	double			,
    imagePromotion		varchar(255)
);

insert into Promotion(promotionId, promotionName, description, valueOfPromotion, imagePromotion)
value	(1, 'Ngày 10-10', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
						   Incidunt, qui quod ipsum harum id', 0.9, 'blog-1.jpg'),
		(2, 'Ngày 20-09', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. 
						   Incidunt, qui quod ipsum harum id', 0.8, 'blog-3.jpg');
        
create table Flight(
	flightId			int		primary key		auto_increment,
    flightDate			date	,
    flightTimeFrom			TIME	,
	flightTimeTo			TIME	,
	flightRouteId		int		,
    aircraftId 			int		,
    promotionID			int	,
    constraint flight_fk_route foreign key(flightRouteId)
    REFERENCES FlightRoute(flightRouteId) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint flight_fk_aircraft foreign key(aircraftId)
    REFERENCES Aircraft(aircraftId) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint flight_fk_promotion foreign key(promotionID)
    REFERENCES Promotion(promotionId) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into Flight(flightDate, flightTimeFrom, flightTimeTo, flightRouteId, aircraftId, promotionID)
Value	('2020-09-12', '08:00:00', '10:00:00',1, 1, 1),
		('2020-09-13', '09:00:00', '11:00:00',2, 2, null),
		('2020-09-12', '10:00:00', '12:00:00',1, 3, null),
		('2020-09-15', '15:00:00', '17:00:00',4, 4, null),
		('2020-09-16', '16:00:00', '18:00:00',5, 5, null),
		('2020-09-17', '18:00:00', '20:00:00',6, 6, null),
		('2020-09-18', '20:00:00', '22:00:00',7, 7, null),
		('2020-09-19', '21:00:00', '23:00:00',8, 8, null);
        
create table Ticket(
	ticketId			int		primary key		auto_increment,
    ticketName			varchar(50)		,
    description			varchar(255),
    price				double			,
    nameOfTheFlyer		varchar(50)		,
    childDateOfBirth	date,
    cmnd				char(9)			,
    ticketIssueDate		date			,
	status				varchar(50)		,
    bookingId 			int				,
    ticketTypeId 		int				,
    ticketClassId 		int				,
    flightId 			int				,
    constraint ticket_fk_booking foreign key(bookingId)
    REFERENCES Booking(bookingId ) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint ticket_fk_tktype foreign key(ticketTypeId)
    REFERENCES TicketType(ticketTypeId) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint ticket_fk_tkclass foreign key(ticketClassId)
    REFERENCES TicketClass(ticketClassId) ON UPDATE SET NULL ON DELETE SET NULL,
    constraint ticket_fk_flight foreign key(flightId)
    REFERENCES Flight(flightId) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into Ticket(ticketName, description, price, nameOfTheFlyer, childDateOfBirth, cmnd, ticketIssueDate,
					status, bookingId, ticketTypeId, ticketClassId, flightId)
Value	('CA123', null, 0, null, null, null, null, 'have tickets', null, null, null, 1),
		('CA456', null, 0, null, null, null, null, 'have tickets', null, null, null, 1),
		('CA789', null, 0, null, null, null, null, 'have tickets', null, null, null, 1),
		('FB123', null, 0, null, null, null, null, 'have tickets', null, null, null, 1),
		('FB456', null, 0, null, null, null, null, 'have tickets', null, null, null, 5),
		('FB789', null, 0, null, null, null, null, 'have tickets', null, null, null, 6),
		('MO123', null, 0, null, null, null, null, 'have tickets', null, null, null, 7),
		('MO456', null, 0, null, null, null, null, 'have tickets', null, null, null, 8);

create table Users(
	userId				int primary key auto_increment,
    userName			varchar(50) ,
    password			varchar(50) ,
    enabled int,
    userRolesId int,
    constraint user_fk foreign key (userRolesId) 
    references user_roles(userRolesId) ON UPDATE SET NULL ON DELETE SET NULL
);

insert into Users(userId, userName, password, enabled)
Value	(1, 'user1', '12345', 1, ),
		(2, 'admin1', 'abc123', 1);
    
create table user_roles(
	userRolesId int  primary key auto_increment,
    userRole_Name			varchar(50),
    role varchar(50)
    
);

insert into user_roles(userName, role)
Value	
		('admin1', 'ROLE_ADMIN'),
		('user1', 'ROLE_USER');



create table img_banner(
	imgId	int 		primary key 	auto_increment,
    imgName varchar(255)
);

insert into img_banner(imgName)
value	('img_bg_5.jpg'),
		('img_bg_4.jpg'),
        ('img_bg_3.jpg'),
        ('img_bg_2.jpg');

CREATE TABLE popularDestination (
    popularDestinationId INT  PRIMARY KEY AUTO_INCREMENT,
    tourName VARCHAR(50),
    place VARCHAR(50),
    price DOUBLE,
    imgPopularDestination VARCHAR(255)
);

insert into popularDestination(tourName, place, price, imgPopularDestination)
value	('Athens, Greece', 'Athens, Greece', '450','tour-1.jpg'),
		('Family Tour in Thailand', 'Athens, Greece', '450','tour-2.jpg'),
        ('Family Tour in Philippines', 'Lipa, Philippines', '450','tour-3.jpg'),
        ('Family Tour in Greece', 'Athens, Greece', '450','tour-4.jpg'),
        ('Family Tour in Greece', 'Athens, Greece', '450','tour-5.jpg'),
        ('Family Tour in Greece', 'Athens, Greece', '450','tour-6.jpg'),
        ('Family Tour in Greece', 'Athens, Greece', '450','tour-7.jpg'),
        ('Family Tour in Greece', 'Athens, Greece', '450','tour-8.jpg');















