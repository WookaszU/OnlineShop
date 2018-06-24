create table PRODUCTS
(
  PRODUCT_ID      INTEGER not null AUTO_INCREMENT,
  NAME            VARCHAR(50) not null,
  PRICE           DOUBLE not null,
  QUANTITY        INTEGER not null,
  IMAGE           longblob,
  PRIMARY KEY(PRODUCT_ID)
);

create table ACCOUNTS
(
  USER_NAME       VARCHAR(20) not null,
  PASSWORD        VARCHAR(20) not null,
  ACTIVE          BIT NOT NULL,
  PRIMARY KEY(USER_NAME)
);

create table ORDERS
(
  ORDER_ID         INTEGER not null AUTO_INCREMENT,
  USER_ID          INTEGER not null,
  ORDER_DATE       datetime not null,
  PRIMARY KEY(ID)
) ;

create table ORDERED_PRODUCTS
(
  ID               INTEGER not null AUTO_INCREMENT,
  PRODUCT_ID       INTEGER not null,
  QUANTITY         INTEGER not null,
  ORDER_ID         INTEGER not null,
  PRIMARY KEY(ID)
);

# ----------------------------------------------------------------------------------------------


create table USER
(
  ID              INTEGER not null AUTO_INCREMENT,
  FIRSTNAME       VARCHAR(50) not null,
  LASTNAME        VARCHAR(50) not null,
  EMAIL           VARCHAR(50) not null,
  PASSWORD        VARCHAR(255) not null,
  PRIMARY KEY(ID)
);

create table ROLE
(
  ID              INTEGER not null AUTO_INCREMENT,
  NAME            VARCHAR(50) not null,
  PRIMARY KEY(ID)
);

create table USERS_ROLES(
  USER_ID         INTEGER not null,
  ROLE_ID         INTEGER not null
);

# ----------------------------------------------------------------------------------------------
alter table products add DESCRIPTION LONGTEXT AFTER NAME;

truncate table products;

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ("PC MSI Nightblade MI3", "Procesor: Intel Core i5 7400
System operacyjny: Windows 10 Home Edition
Karta graficzna: nVIDIA® GeForce GTX1050", 2999, 10, LOAD_FILE("D:\SHOP\PC.jpg"));

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ("Laptop Dell E6230", "Procesor: i5 3.2 GHz, 2 rdzenie Pamięć RAM: 8 GB Dysk twardy: SSD 128 GB", 1099, 15, LOAD_FILE("D:\SHOP\Laptop.jpg"));

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ("Słuchawki nauszne JBL", "Dynamika [dB]: 107
Impedancja [Ω]: 32
Pasmo przenoszenia [Hz]: 20 - 20k", 106, 200, LOAD_FILE("D:\SHOP\Headphones.jpg"));

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ("Głośnik Boombox", "Komunikacja: bluetooth
Moc (W): 10
Zasilanie: akumulatorowe", 61, 80, LOAD_FILE("D:\SHOP\Speakers.jpg"));


