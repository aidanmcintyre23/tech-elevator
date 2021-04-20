begin transaction;

UPDATE day_of_week
SET name = 'Thursday'
WHERE day_id = 4;

commit;