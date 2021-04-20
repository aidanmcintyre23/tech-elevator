begin transaction;

insert into day_of_week (day_id, name)
values(1,'Monday'),
      (2,'Tuesday'),
      (3,'Wednesday'),
      (4,'Thurday'),
      (5,'Friday'),
      (6,'Saturday'),
      (7,'Sunday');
      
insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 1, '8:00 AM', '5:00 PM');

insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 2, 'CLOSED', 'CLOSED');

insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 3, '8:00 AM', '5:00 PM');
   
insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 4, 'CLOSED', 'CLOSED');
   
insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 5, '8:00 AM', '5:00 PM');
   
insert into open_hours (destination_id, day_id, open, close)
values((select destination_id from destinations where name = 'West Side Market'), 6, '7:00 AM', '5:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values((select destination_id from destinations where name = 'West Side Market'), 7, '10:00 AM', '4:00 PM');
    
   insert into open_hours (destination_id, day_id, open, close)    
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 1, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 2, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 3, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 4, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 5, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 6, 'Hours vary: See website', 'Hours vary: See website');
   
   insert into open_hours (destination_id, day_id, open, close)
   values   ((select destination_id from destinations where name = 'Edgewater Beach'), 7, 'Hours vary: See website', 'Hours vary: See website');

   insert into open_hours (destination_id, day_id, open, close)
   values ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 1, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 2, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 3, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values  ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 4, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values  ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 5, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values  ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 6, '8:00 AM', '10:00 PM');
   
   insert into open_hours (destination_id, day_id, open, close)
   values  ((select destination_id from destinations where name = 'Cleveland Cultural Gardens'), 7, '8:00 AM', '10:00 PM');

    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 1, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 2, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
   
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 3, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 4, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 5, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 6, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'The Mall'), 7, 'Hours vary depending on local events, store hours, and restaurant hours.', 'Hours vary depending on local events, store hours, and restaurant hours.');

    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Playhouse Square'), 1, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Playhouse Square'), 2, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Playhouse Square'), 3, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Playhouse Square'), 4, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Playhouse Square'), 5, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Playhouse Square'), 6, '11:00AM', '6:00PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Playhouse Square'), 7, '11:00AM', '6:00PM');

    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 1, 'CLOSED', 'CLOSED');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 2, '12:00 PM', '6:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 3, '12:00 PM', '6:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 4, '12:00 PM', '6:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 1, '12:00 PM', '7:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 1, '12:00 PM', '7:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Buckland Museum of Witchcraft & Magick'), 1, '12:00 PM', '3:00 PM');
       
    insert into open_hours (destination_id, day_id, open, close)
    values ((select destination_id from destinations where name = 'Bedford Reservation'), 1, '6:00AM', '11:00PM');
     
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Bedford Reservation'), 2, '6:00AM', '11:00PM');
     
    insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Bedford Reservation'), 3, '6:00AM', '11:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Bedford Reservation'), 4, '6:00AM', '11:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Bedford Reservation'), 5, '6:00AM', '11:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Bedford Reservation'), 6, '6:00AM', '11:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Bedford Reservation'), 7, '6:00AM', '11:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values    ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 1, '10:00AM', '4:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 2, '10:00AM', '4:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 3, '10:00AM', '4:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 4, '10:00AM', '4:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 5, '10:00AM', '4:00PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 6, 'Check website to book a tour', 'Check website to book a tour');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'International Women''s Air & Space Museum'), 7, 'CLOSED', 'CLOSED');
       
       
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 1, 'CLOSED', 'CLOSED');
    
    insert into open_hours (destination_id, day_id, open, close)
    values    ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 2, 'CLOSED', 'CLOSED');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 3, 'CLOSED', 'CLOSED');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 4, 'CLOSED', 'CLOSED');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 5, '12:00 PM', '10:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 6, '12:00 PM', '10:00 PM');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Great Lakes Brewing Company'), 7, '12:00 PM', '6:00 PM');
       
       
    insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'A Christmas Story House'), 1, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'A Christmas Story House'), 2, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'A Christmas Story House'), 3, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'A Christmas Story House'), 4, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'A Christmas Story House'), 5, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'A Christmas Story House'), 6, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'A Christmas Story House'), 7, '10:00 AM', '5:00 PM');

     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 1, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 2, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 3, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 4, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 5, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 6, '11:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Rock & Roll Hall of Fame'), 7, '11:00 AM', '5:00 PM');

     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 1, 'CLOSED', 'CLOSED');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 2, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 3, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 4, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 5, '11:00 AM', '8:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 6, '11:00 AM', '8:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Botanical Garden'), 7, '12:00 PM', '5:00 PM');


     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 1, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 2, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 3, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 4, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 5, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 6, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Cleveland Metroparks Zoo'), 7, '10:00 AM', '5:00 PM');


     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 1, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 2, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values    ((select destination_id from destinations where name = 'Progressive Field'), 3, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 4, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 5, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 6, 'Hours vary: See website', 'Hours vary: See website');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Progressive Field'), 7, 'Hours vary: See website', 'Hours vary: See website');

     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 1, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 2, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values    ((select destination_id from destinations where name = 'Lake View Cemetery'), 3, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 4, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 5, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 6, '7:30 AM', '6:30 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Lake View Cemetery'), 7, '7:30 AM', '6:30 PM');
     
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 1, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values    ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 2, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values   ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 3, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 4, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 5, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values  ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 6, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');
    
    insert into open_hours (destination_id, day_id, open, close)
    values    ((select destination_id from destinations where name = 'Historic Little Italy in Cleveland'), 7, 'Hours vary depending on local events, store hours, and restaurant hours', 'Hours vary depending on local events, store hours, and restaurant hours');

     insert into open_hours (destination_id, day_id, open, close)
     values    ((select destination_id from destinations where name = 'Severance Hall'), 1, '9:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Severance Hall'), 2, '9:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Severance Hall'), 3, '9:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Severance Hall'), 4, '9:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Severance Hall'), 5, '9:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Severance Hall'), 6, '10:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values  ((select destination_id from destinations where name = 'Severance Hall'), 7, 'CLOSED', 'CLOSED');

     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 1, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 2, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 3, '10:00 AM', '5:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 4, '10:00 AM', '5:00 PM');
     
    insert into open_hours (destination_id, day_id, open, close)
    values((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 5, '10:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 6, '10:00 AM', '6:00 PM');
     
     insert into open_hours (destination_id, day_id, open, close)
     values   ((select destination_id from destinations where name = 'Greater Cleveland Aquarium'), 7, '10:00 AM', '6:00 PM');

      insert into open_hours (destination_id, day_id, open, close)
      values   ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 1, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values  ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 2, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values   ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 3, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values  ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 4, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values  ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 5, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values  ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 6, '12:00 AM', '12:00 AM');
      
      insert into open_hours (destination_id, day_id, open, close)
      values ((select destination_id from destinations where name = 'JACK Cleveland Casino'), 7, '12:00 AM', '12:00 AM');

commit;
