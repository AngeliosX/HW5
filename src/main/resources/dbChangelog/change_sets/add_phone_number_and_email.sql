alter table shops
    add if not exists telephone_number varchar(100),
    add if not exists email varchar(100);