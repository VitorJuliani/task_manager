CREATE TABLE IF NOT EXISTS authorities (
    id SERIAL PRIMARY KEY,
    authority VARCHAR NOT NULL,
    user_id INT NOT NULL REFERENCES users(id)
)
