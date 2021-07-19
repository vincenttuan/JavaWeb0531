select * from Book;
select name from Book;
select b.ID, b.TS, b.PRICE, b."NAME" from Book b;

select b."NAME", b.PRICE, b.AMOUNT, (b.PRICE * b.AMOUNT) as subtotal
from book b
order by b.PRICE desc; -- asc(預設:小->大), desc(大->小)

select b."NAME", sum(b.PRICE * b.AMOUNT) as subtotal
from book b
group by b."NAME";
