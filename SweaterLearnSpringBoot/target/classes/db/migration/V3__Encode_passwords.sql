
create extension if not exists pgcrypto;

update usr1 set password = crypt(password, gen_salt('bf', 8));