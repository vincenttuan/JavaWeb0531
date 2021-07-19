-- 價格一律加 10%
--update book set price = price * 1.1;

-- 價格一律 1 元
--update book set price = 1;

-- 修改 id=1 的資料 name=Java8 price=200
--update book set name='Java8', price=200 where id=1;
update book b set b."NAME"='Java8', b.PRICE=200 where b.ID=1;