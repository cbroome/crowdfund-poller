
CREATE TABLE IF NOT EXISTS campaign_type (
    id SERIAL,
    name VARCHAR(100),
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS campaign (
    id SERIAL,
    campaign_type_id INTEGER REFERENCES campaign_type(id),
    summary TEXT,
    url TEXT,
    description TEXT,
    start_date DATE,
    end_date DATE,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS campaign_image (
    id SERIAL,
    campaign_id INTEGER REFERENCES campaign(id),
    url TEXT,
    is_primary BOOLEAN,
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS kiva_campaign (
    id INTEGER,
    campaign_id INTEGER REFERENCES campaign(id)
);


CREATE TABLE IF NOT EXISTS donors_choose_proposal (
    id INTEGER,
    campaign_id INTEGER REFERENCES campaign(id),
    school_name TEXT,
    school_url TEXT
);