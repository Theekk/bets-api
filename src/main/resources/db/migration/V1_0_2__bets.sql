CREATE TABLE users (
id INTEGER PRIMARY KEY,
name varchar(32),
balance float
);

CREATE TABLE bets (
id INTEGER NOT NULL REFERENCES users (id),
userId INTEGER PRIMARY KEY,
betAmount FLOAT,
chance FLOAT,
payout FLOAT,
win BOOL
);