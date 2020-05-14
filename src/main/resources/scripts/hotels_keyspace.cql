create keyspace k_hotels with replication = {'class' : 'SimpleStrategy', 'replication_factor' : 3};

use k_hotels;

create type address(
	city varchar,
	state varchar,
	country varchar,
	zip_code varchar
);

create table hotels_by_poi(
	name varchar,
	phone varchar,
	address frozen<address>,
	poi_name varchar,

	primary key(poi_name)
);

create table hotels_by_name(
	name varchar,
	phone varchar,
	address frozen<address>,

	primary key(name)
);

create table poi_by_hotel(
	name varchar,
	description varchar,
	hotel_name varchar,

	primary key (hotel_name)
);

create table rooms_availability(
	hotel_name varchar,
	availability_date date,
	room_number int,
	is_available boolean,

	primary key(hotel_name, availability_date)
) with clustering order by (availability_date DESC);

create table rooms(
	hotel_name varchar,
	room_number int,
	price int,
	amenities list<frozen<tuple<text, text, text>>>,

	primary key(hotel_name, room_number)
) with clustering order by (room_number DESC);