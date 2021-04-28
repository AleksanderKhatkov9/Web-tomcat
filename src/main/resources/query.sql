-- select database user
SELECT * FROM webdb.user;
INSERT INTO webdb.user(user_id, user_name, password,email) VALUES(1 ,'Sasha','1234','bendar@tut.by');
-- select database book
SELECT * FROM webdb.book;
INSERT INTO webdb.book(id, title, author, price) VALUES(1 ,'Java EE','Horstman','50.0');
SELECT * FROM webdb.book Where id=86;

-- DELETE
DELETE FROM webdb.book WHERE id= 1;
DELETE FROM webdb.book WHERE id  BETWEEN 80 AND 83;
-- UPDATE
update webdb.book set title='java', author='Horstman', price='67'Where id =94;

