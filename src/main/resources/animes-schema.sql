drop table if exists animes CASCADE;
CREATE TABLE animes (
    id BIGINT AUTO_INCREMENT,
    anime_genre VARCHAR(255),
    anime_name VARCHAR(255),
    anime_studio VARCHAR(255),
    year_of_production INTEGER NOT NULL,
    PRIMARY KEY (id)
);