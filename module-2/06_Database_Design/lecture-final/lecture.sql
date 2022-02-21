
DROP TABLE IF EXISTS customer_purchase;
DROP TABLE IF EXISTS art;
DROP TABLE IF EXISTS customer;   -- <-- warning!!! use with caution!!!
DROP TABLE IF EXISTS artist;

CREATE TABLE customer (
	customerid SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	address VARCHAR(100) NOT NULL,
	phone VARCHAR(12) NOT NULL
	
);

CREATE TABLE artist (
	artistid SERIAL NOT NULL PRIMARY KEY,
	firstname VARCHAR(64) NOT NULL,
	lastname VARCHAR(64) NOT NULL
);

CREATE TABLE art (
	artcodeid SERIAL NOT NULL PRIMARY KEY,
	title VARCHAR(64) NOT NULL,
	artistid INT NOT NULL CONSTRAINT fk_artist REFERENCES artist(artistid)
);

CREATE TABLE customer_purchase (
	customerid INT NOT NULL CONSTRAINT fk_customer REFERENCES customer(customerid),
	artcodeid INT NOT NULL CONSTRAINT fk_art REFERENCES art(artcodeid),
	purchasedate TIMESTAMP NOT NULL,
	price MONEY NOT NULL,
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customerid, artcodeid, purchasedate)

);

ALTER TABLE customer_purchase
	ADD COLUMN solddate TIMESTAMP NULL;




