package com.company.footballgame.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "FOOTBALLGAME_LOG_TABLE")
@Entity(name = "footballgame_LogTable")
public class LogTable extends StandardEntity {
    private static final long serialVersionUID = -9076280203578509063L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_NAME_ID")
    @OnDelete(DeletePolicy.CASCADE) // Ensures one-to-one relation uniqueness
    private Team team;

    @NotNull // Ensures that these fields cannot be null
    @Column(name = "WINS", nullable = false)
    private Integer wins = 0;

    @NotNull
    @Column(name = "LOSSES", nullable = false)
    private Integer losses = 0;

    @NotNull
    @Column(name = "DRAWS", nullable = false)
    private Integer draws = 0;

    @NotNull
    @Column(name = "GOALS_FOR", nullable = false)
    private Integer goalsFor = 0;

    @NotNull
    @Column(name = "GOALS_AGAINST", nullable = false)
    private Integer goalsAgainst = 0;

    @NotNull
    @Column(name = "POINTS", nullable = false)
    private Integer points = 0;


    // Getters and setters...


    // Existing LogTable entity code...

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(Integer goalsFor) {
        this.goalsFor = goalsFor;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(Integer goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}


