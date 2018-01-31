
CREATE TABLE IF NOT EXISTS campaign (
    id SERIAL,
    summary TEXT,
    url TEXT,
    description TEXT
);

CREATE TABLE IF NOT EXISTS campaign_image (
    id SERIAL,
    campaign_id INTEGER REFERENCES campaign(id),
    url TEXT,
    is_primary BOOLEAN
);