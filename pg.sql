create sequence PRODUCTS_seq;

create table PRODUCTS
(
  PRODUCT_ID      INTEGER not null DEFAULT NEXTVAL ('PRODUCTS_seq'),
  NAME            VARCHAR(50) not null,
  DESCRIPTION	  TEXT,
  PRICE           DOUBLE PRECISION not null,
  QUANTITY        INTEGER not null,
  IMAGE           oid,
  PRIMARY KEY(PRODUCT_ID)
);

create table ACCOUNTS
(
  USER_NAME       VARCHAR(20) not null,
  PASSWORD        VARCHAR(20) not null,
  ACTIVE          BOOLEAN NOT NULL,
  PRIMARY KEY(USER_NAME)
);

create sequence ORDERS_seq;

create table ORDERS
(
  ID               INTEGER not null DEFAULT NEXTVAL ('ORDERS_seq'),
  AMOUNT           double precision not null,
  CUSTOMER_ADDRESS VARCHAR(255) not null,
  CUSTOMER_EMAIL   VARCHAR(128) not null,
  CUSTOMER_NAME    VARCHAR(255) not null,
  CUSTOMER_PHONE   VARCHAR(128) not null,
  ORDER_DATE       timestamp(0) not null,
  ORDER_NUM        INTEGER not null,
  PRIMARY KEY(ID)
) ;
-- ----------------------------------------------------------------------------------------------


create sequence USER_seq;

create table USERS
(
  ID              INTEGER not null DEFAULT NEXTVAL ('USER_seq'),
  FIRSTNAME       VARCHAR(50) not null,
  LASTNAME        VARCHAR(50) not null,
  EMAIL           VARCHAR(50) not null,
  PASSWORD        VARCHAR(255) not null,
  PRIMARY KEY(ID)
);

create sequence ROLE_seq;

create table ROLE
(
  ID              INTEGER not null DEFAULT NEXTVAL ('ROLE_seq'),
  NAME            VARCHAR(50) not null,
  PRIMARY KEY(ID)
);

create table USERS_ROLES(
  USER_ID         INTEGER not null,
  ROLE_ID         INTEGER not null
);

-- ----------------------------------------------------------------------------------------------


insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ('PC MSI Nightblade MI3', 'Procesor: Intel Core i5 7400
System operacyjny: Windows 10 Home Edition
Karta graficzna: nVIDIA® GeForce GTX1050', 2999, 10, null);

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ('Laptop Dell E6230', 'Procesor: i5 3.2 GHz, 2 rdzenie Pamięć RAM: 8 GB Dysk twardy: SSD 128 GB', 1099, 15, null);

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ('Słuchawki nauszne JBL', 'Dynamika [dB]: 107
Impedancja [Ω]: 32
Pasmo przenoszenia [Hz]: 20 - 20k', 106, 200, null);

insert into products(NAME, DESCRIPTION, PRICE, QUANTITY, IMAGE) values ('Głośnik Boombox', 'Komunikacja: bluetooth
Moc (W): 10
Zasilanie: akumulatorowe', 61, 80, null);


