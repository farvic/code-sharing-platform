CREATE TABLE codes (
                        id VARCHAR(36) PRIMARY KEY,
                        code_snippet VARCHAR(255) NOT NULL,
                        date DATETIME NOT NULL,
                        time BIGINT NOT NULL,
                        time_restricted BOOLEAN NOT NULL,
                        views BIGINT NOT NULL,
                        views_restricted BOOLEAN NOT NULL
);

-- CREATE table orders (
--                         seat_id int UNIQUE NOT NULL,
--                         token VARCHAR(36) PRIMARY KEY
-- );