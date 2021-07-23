select * from Book;
select name from Book;
select b.ID, b.TS, b.PRICE, b."NAME" from Book b;

select b."NAME", b.PRICE, b.AMOUNT, (b.PRICE * b.AMOUNT) as subtotal
from book b
order by b.PRICE desc; -- asc(預設:小->大), desc(大->小)

select b."NAME", sum(b.PRICE * b.AMOUNT) as subtotal
from book b
group by b."NAME";

-- 計算每本平均價格
SELECT b."NAME", SUM(b.PRICE * b.AMOUNT) as subtotal,
       SUM(b.AMOUNT) as amount, 
       SUM(b.PRICE * b.AMOUNT) / SUM(b.AMOUNT) as avg_price
FROM BOOK b
GROUP BY b."NAME"

-- 全部書籍總價值 ?
select SUM(b.PRICE * b.AMOUNT) as total from book b

-- Homework 計算每種書籍價值, 佔比
SELECT b."NAME", SUM(b.PRICE * b.AMOUNT) as subtotal, 0.5 as percent
FROM BOOK b
GROUP BY b."NAME";
