begin transaction;

update open_hours
set open = 'Hours vary'
where open = 'Hours vary depending on local events, store hours, and restaurant hours.'
OR open = 'Hours vary depending on local events, store hours, and restaurant hours';

update open_hours
set close = 'Check website'
where close = 'Hours vary depending on local events, store hours, and restaurant hours.'
OR close = 'Hours vary depending on local events, store hours, and restaurant hours';

update destinations
set image = 'https://ssl.cdn-redfin.com/photo/159/bigphoto/534/4112534_12_1.jpg'
where name = 'Historic Little Italy in Cleveland';

update destinations
set image = 'https://ideastream-production.s3.amazonaws.com/styles/feature_image_new/s3/uploads/2019/7/02/MallTowerCityshutterstock_0.jpg?null&itok=RKlmfoE6'
where name = 'The Mall';

update destinations
set image = 'https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fwww.casino.org%2Fnews%2Fwp-content%2Fuploads%2F2019%2F10%2Fjack102819.jpg'
where name = 'JACK Cleveland Casino';

update destinations
set image = 'https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fs.wsj.net%2Fpublic%2Fresources%2Fimages%2FBN-TX747_JAPANR_M_20170619105228.jpg'
where name = 'Rock & Roll Hall of Fame';

update destinations
set image = 'https://slack-imgs.com/?c=1&o1=ro&url=https%3A%2F%2Fsosassociates.com%2Fsites%2Fdefault%2Ffiles%2FCleveland-Metroparks-Zoo.jpg'
where name = 'Cleveland Metroparks Zoo';

update destinations
set image = 'https://i.pinimg.com/originals/6b/85/2f/6b852fad91a8439febc3b72838301f88.jpg'
where name = 'West Side Market';
commit;
