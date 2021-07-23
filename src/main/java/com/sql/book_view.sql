--BookStatView
SELECT b."NAME", 
        SUM(b.AMOUNT) as amount, 
        SUM(b.AMOUNT * b.PRICE) as subtotal,
        SUM(b.AMOUNT * b.PRICE) / SUM(b.AMOUNT) as avgprice
FROM Book b
GROUP BY b."NAME"



