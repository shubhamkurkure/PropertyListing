create table person (
id int not null auto_increment, first_name varchar(100), last_name varchar(100), gender varchar(100), email varchar(100),
dob date, primary key (id)
);

create table phone_numbers (
id int not null auto_increment, phone_no varchar(100), `is_primary` boolean, person_id int, 
primary key (id), foreign key (person_id) references person(id) on delete cascade on update cascade);

create table addresses (
id int not null auto_increment, address varchar(100), city varchar(100), zip int, state varchar(100), country varchar(100), `is_primary` boolean, 
person_id int, primary key (id), foreign key (person_id) references person(id) on delete cascade on update cascade);

create table login (
id int primary key not null auto_increment, username varchar(100), password varchar(100), person_id int,
foreign key (person_id) references person(id) on delete cascade on update cascade);

create table hosts ( 
id int not null auto_increment, superhost boolean, type varchar(45), 
primary key (id), foreign key (id) references person(id) on delete cascade on update cascade);

create table guests ( 
id int not null auto_increment, verified boolean, type varchar(45),
primary key (id), foreign key (id) references person(id) on delete cascade on update cascade);

create table admin ( 
id int not null auto_increment, type varchar(45),
primary key (id), foreign key (id) references person(id) on delete cascade on update cascade);

create table property_types (
id int primary key not null auto_increment, type varchar(100) );
insert into property_types(id, type) values(1, "Entire floor"),(2, "loft"),(3, "Townhouse"),(4, "Villa");

create table properties ( 
id int primary key not null auto_increment, price int, name varchar(100), property_type_id int, no_of_rooms int, verified boolean, 
max_no_of_person int, description varchar(10000), host_id int, sub_property_id int,
foreign key (property_type_id) references property_types(id), foreign key (host_id) references hosts(id),
foreign key (sub_property_id) references properties(id));

create table property_address (
id int primary key not null auto_increment, latitude int, longitude int, city varchar(100), state varchar(100), country varchar(100),
property_id int(11),address varchar(100), 
foreign key (property_id) references properties(id) on delete cascade on update cascade);

create table images (
id int primary key not null auto_increment, url varchar(1000), 
type varchar(100), property_id int, foreign key (property_id) references properties(id) on delete cascade on update cascade);

create table availabilities (
id int primary key not null auto_increment, `d_from` date, `d_to` date, property_id int,
foreign key (property_id) references properties(id) on delete cascade on update cascade);

create table trips (
id int primary key not null auto_increment, `start` date, `end` date, 
property_id int, guest_id int, foreign key (property_id) references properties(id), foreign key (guest_id) references guests(id) );

create table payment_types (
id int primary key not null auto_increment, type varchar(100) );
insert into payment_types(id, type) values(1, "Debit card"),(2, "Credit card"),(3, "Wallet"),(4, "Cash");

create table payment_details( 
id int primary key not null auto_increment, payment_type_id int, payment_date date, amount int, 
trip_id int, foreign key (trip_id) references trips(id), foreign key (payment_type) references payment_types(id) );

create table reviews ( 
id int primary key not null auto_increment, guest_review varchar(1000), property_review varchar(1000), host_review varchar(1000),
host_rating int, guest_rating int, property_rating int, trip_id int, guest_id int, host_id int, given_by varchar(45),
foreign key (trip_id) references trips(id) on delete cascade on update cascade, 
foreign key (guest_id) references guests(id), foreign key (host_id) references hosts(id) );

create table invitees (
trip_id int, invitee_id int, 
primary key (trip_id,invitee_id), 
foreign key (trip_id) references trips(id) on delete cascade on update cascade, 
foreign key (invitee_id) references guests(id));


