CREATE TABLE IF NOT EXISTS users(
                      id SERIAL PRIMARY KEY,
                      first_name varchar(50) not null,
                      last_name varchar(50) not null,
                      phone_number varchar(50) unique not null,
                      password varchar(100) not null);

insert into users (first_name, last_name, phone_number, password) VALUES
    (
        'German',
        'Gref',
        '+88005553535',
        'q1'
    );