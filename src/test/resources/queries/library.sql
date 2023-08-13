select count(id) from users; -- actual data

select count( distinct id) from users; -- expected (unique values)
-- if these two numbers match -> we have all unique id's (User story 1)

select name from book_categories;
