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
    TEAM_NAME_ID varchar(36) not null,
    WINS integer not null,
    LOSSES integer not null,
    DRAWS integer not null,
    GOALS_FOR integer not null,
    GOALS_AGAINST integer not null,
    POINTS integer not null,
    --
    primary key (ID)
);