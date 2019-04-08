INSERT INTO campaign_type (id, name)
VALUES (1, 'kiva'), (2, 'donorschoose')
ON CONFLICT (id) DO UPDATE
  SET name = excluded.name;