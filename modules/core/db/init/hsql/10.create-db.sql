-- begin FOOTBALLGAME_TEAM
create table FOOTBALLGAME_TEAM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end FOOTBALLGAME_TEAM
-- begin FOOTBALLGAME_LOG_TABLE
create table FOOTBALLGAME_LOG_TABLE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEAM_NAME_ID varchar(36),
    WINS integer not null,
    LOSSES integer not null,
    DRAWS integer not null,
    GOALS_FOR integer not null,
    GOALS_AGAINST integer not null,
    POINTS integer not null,
    --
    primary key (ID)
)^
-- end FOOTBALLGAME_LOG_TABLE
-- begin FOOTBALLGAME_FIXTURE
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
    SCORES_UPDATED boolean,
    --
    primary key (ID)
)^
-- end FOOTBALLGAME_FIXTURE
