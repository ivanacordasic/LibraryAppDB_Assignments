select count(id) from users; -- actual data

select count( distinct id) from users; -- expected (unique values)
-- if these two numbers match -> we have all unique id's (User story 1)

select name from book_categories;

select * from users;

select count(*) from book_borrow where is_returned = 0;

select * from books where name like 'rich dad poor dad';

select bc.name, count(*) from book_borrow
inner join books b on book_borrow.book_id = b.id
inner join book_categories bc on b.book_category_id = bc.id
group by name
order by 2 desc ;
