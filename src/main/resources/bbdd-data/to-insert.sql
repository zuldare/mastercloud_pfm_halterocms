-- Competitions
INSERT INTO halterocms.competition (id, end_date, inscription_end_date, inscription_start_date, location, name, organizer, start_date, `type`)
VALUES(1, '2022-05-10', '2022-05-07', '2022-05-05', 'Pabellón Municipal Perico Palotes', 'Campeonato de España Senior', 'Federación Española de Halterofilia', '2022-05-08', 'Senior');

-- Batches
INSERT INTO halterocms.batch (id, `date`, gender, platform, start_time, weighin_time, competition_id)
VALUES(1, '2022-05-09', 'male', '1A', '10:05:00', '08:30:00', 1);

-- Lifters
INSERT INTO halterocms.lifter (id, competition_id, birth_year, category, club, name)
VALUES(1, 1, '1981', '109', 'URSS', 'Anatoly Pisarenko');
INSERT INTO halterocms.lifter (id, competition_id, birth_year, category, club, name)
VALUES(2, 1, '1986', '109', 'USA', 'John Doe');

-- Weighins
INSERT INTO halterocms.weighin (id, body_weight, clean_and_jerk_opener, snatch_opener, `time`, lifter_id)
VALUES(1, 108.56, NULL, NULL, NULL, 1);
INSERT INTO halterocms.weighin (id, body_weight, clean_and_jerk_opener, snatch_opener, `time`, lifter_id)
VALUES(2, 106.0, NULL, NULL, NULL, 2);

-- Batches-lifters relation
INSERT INTO halterocms.batch_lifter (id, draw_order, batch_id, lifter_id, weighin_id)
VALUES(1, 234, 1, 1, 1);
INSERT INTO halterocms.batch_lifter (id, draw_order, batch_id, lifter_id, weighin_id)
VALUES(2, 1, 1, 2, 2);


