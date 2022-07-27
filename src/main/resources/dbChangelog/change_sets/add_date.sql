alter table shops
    add if not exists creation_date date default current_date;