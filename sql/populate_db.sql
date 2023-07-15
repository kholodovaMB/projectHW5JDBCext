INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
  ('Alex', '1990-05-15', 'Trainee', 800),
  ('Jana', '1985-10-22', 'Junior', 1200),
  ('Mike', '1982-07-07', 'Middle', 3000),
  ('Maryna', '1978-12-31', 'Senior', 6000),
  ('Oleg', '1992-03-18', 'Middle', 2500),
  ('Dima', '1994-08-25', 'Junior', 1500),
  ('Sasha', '1989-01-10', 'Senior', 7000),
  ('Olgar', '1987-06-05', 'Middle', 4000),
  ('Andrey', '1991-09-12', 'Trainee', 900),
  ('Sophia', '1993-04-20', 'Junior', 1100);

INSERT INTO client (NAME)
VALUES
  ('Meta Company'),
  ('Amazone Corporation'),
  ('LVT Industries'),
  ('Apple Corporation'),
  ('Ewa Enterprises');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
  (1, '2022-01-01', '2022-02-15'),
  (2, '2022-03-10', '2022-05-20'),
  (3, '2022-06-01', '2022-09-30'),
  (4, '2022-08-15', '2023-01-31'),
  (5, '2022-10-01', '2023-03-15'),
  (1, '2022-04-01', '2022-06-30'),
  (3, '2022-07-10', '2022-08-20'),
  (2, '2022-09-01', '2023-02-28'),
  (4, '2023-03-15', '2023-06-30'),
  (5, '2023-01-01', '2023-05-31');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
  (1, 2),
  (2, 3),
  (2, 4),
  (3, 5),
  (3, 6),
  (4, 7),
  (5, 8),
  (6, 9),
  (6, 10),
  (6, 7),
  (6, 6),
  (6, 2),
  (7, 1),
  (7, 3),
  (8, 2),
  (8, 5),
  (9, 6),
  (9, 8),
  (10, 4),
  (10, 9),
  (10, 1);