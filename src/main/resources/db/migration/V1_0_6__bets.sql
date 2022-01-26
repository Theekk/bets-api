drop table if exists bets;
drop table if exists users;

CREATE TABLE users (
    id uuid PRIMARY KEY,
    name VARCHAR(255),
    balance NUMERIC
);

CREATE TABLE bets (
  id uuid PRIMARY KEY,
  user_id uuid NOT NULL,
  bet_amount NUMERIC,
  chance NUMERIC,
  payout NUMERIC,
  win BOOLEAN
);


ALTER TABLE bets ADD FOREIGN KEY(user_id) REFERENCES users (id);