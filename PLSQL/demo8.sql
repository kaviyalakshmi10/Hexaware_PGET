set serveroutput on;

declare
  book_name books.name%type := '&book_name';
  price books.price%type;
  book_type books.book_type%type;
  discount number;
begin
  select price, book_type
  into price, book_type
  from books
  where lower(name) = lower(book_name);

  if lower(book_type) = 'it' then
    discount := price * 0.05;
  else
    discount := price * 0.10;
  end if;

  update books
  set price = price - discount
  where lower(name) = lower(book_name);

  dbms_output.put_line('book: ' || book_name || ', new price: ' || (price - discount));
end;
/
