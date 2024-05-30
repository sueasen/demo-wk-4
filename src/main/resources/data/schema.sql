CREATE TABLE IF NOT EXISTS poll (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    question VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS choice (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    votes INT DEFAULT 0,
    poll_id BIGINT,
    FOREIGN KEY (poll_id) REFERENCES poll(id) ON DELETE CASCADE
);