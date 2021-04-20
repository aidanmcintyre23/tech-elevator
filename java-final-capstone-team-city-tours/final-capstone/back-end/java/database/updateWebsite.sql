begin transaction;

UPDATE destinations
SET website = 'http://www.ohiocity.org/west-side-market'
WHERE name = 'West Side Market';


UPDATE destinations
SET website = 'http://localhost:8081/destinations/1:42https://www.greaterclevelandaquarium.com/'
WHERE name = 'Greater Cleveland Aquarium';

commit;