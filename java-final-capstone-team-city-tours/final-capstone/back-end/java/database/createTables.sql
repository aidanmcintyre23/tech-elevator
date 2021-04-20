
drop table if exists open_hours;
drop table if exists destinations CASCADE;
drop table if exists day_of_week;

create table destinations
(
  destination_id serial       NOT NULL,
  name           varchar(50)  NOT NULL,
  description    text         NOT NULL,
  street_address varchar(100) NOT NULL,
  city           varchar(10)  DEFAULT 'Cleveland',
  state          char(2)      DEFAULT 'OH',
  zipcode        varchar(10)  NOT NULL,
  latitude       decimal(16,14) NOT NULL,
  longitude      decimal(16,14) NOT NULL,
  website        varchar(100) NOT NULL,
  type           varchar(25)  NOT NULL,
  image          varchar(500) NOT NULL,
  constraint pk_destinations primary key (destination_id)
);

create table day_of_week
(
  day_id        serial         NOT NULL,
  name          varchar(10)    NOT NULL,
  constraint pk_day_of_week    primary key (day_id)
);

create table open_hours
(
  hours_id       serial       NOT NULL,
  destination_id int          NOT NULL,
  day_id         int          NOT NULL,
  open           varchar(100),       
  close          varchar(100),
  constraint pk_open_hours     primary key (hours_id),
  constraint fk_destination_id foreign key (destination_id) references destinations (destination_id),
  constraint fk_day_id          foreign key (day_id)         references day_of_week (day_id)
);
