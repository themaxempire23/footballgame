create table FOOTBALLGAME_FIXTURE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEAM1_ID varchar(36) not null,
    TEAM2_ID varchar(36) not null,
    SCORE1 integer,
    SCORE2 integer,
    MATCH_DATE date,
    --
    primary key (ID)
);