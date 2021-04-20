drop table if exists itinerary_destination;
drop table if exists itinerary;


create table itinerary (
 
 itinerary_id      serial       NOT NULL,
 user_id            int         NOT NULL,
 starting_point    varchar(250) NOT NULL,
 date              varchar(50)  NOT NULL,            
 constraint pk_intinerary primary key(itinerary_id),
 constraint fk_user_id foreign key(user_id) references users(user_id)

);

create table itinerary_destination (

itinerary_id   int NOT NULL,
destination_id int NOT NULL,

constraint fk_itinerary_id    foreign key(itinerary_id) references itinerary(itinerary_id),
constraint fk_destinations_id  foreign key(destination_id) references destinations(destination_id)

);