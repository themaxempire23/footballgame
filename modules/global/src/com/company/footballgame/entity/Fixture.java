//package com.company.footballgame.entity;
//
//import com.haulmont.cuba.core.entity.StandardEntity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Table(name = "FOOTBALLGAME_FIXTURE")
//@Entity(name = "footballgame_Fixture")
//public class Fixture extends StandardEntity {
//    private static final long serialVersionUID = 4416821882665031377L;
//
//    @JoinColumn(name = "TEAM1_ID")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Team team1;
//
//    @JoinColumn(name = "TEAM2_ID")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Team team2;
//
//    @Column(name = "SCORE1")
//    private Integer score1;
//
//    @Column(name = "SCORE2")
//    private Integer score2;
//
//    @Temporal(TemporalType.DATE)
//    @Column(name = "MATCH_DATE")
//    private Date matchDate;
//
//    public Date getMatchDate() {
//        return matchDate;
//    }
//
//    public void setMatchDate(Date matchDate) {
//        this.matchDate = matchDate;
//    }
//
//    public Integer getScore2() {
//        return score2;
//    }
//
//    public void setScore2(Integer score2) {
//        this.score2 = score2;
//    }
//
//    public Integer getScore1() {
//        return score1;
//    }
//
//    public void setScore1(Integer score1) {
//        this.score1 = score1;
//    }
//
//    public void setTeam1(Team team1) {
//        this.team1 = team1;
//    }
//
//    public Team getTeam1() {
//        return team1;
//    }
//
//    public void setTeam2(Team team2) {
//        this.team2 = team2;
//    }
//
//    public Team getTeam2() {
//        return team2;
//    }
//
//}

package com.company.footballgame.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FOOTBALLGAME_FIXTURE")
@Entity(name = "footballgame_Fixture")
public class Fixture extends StandardEntity {
    private static final long serialVersionUID = 4416821882665031377L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEAM1_ID")
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TEAM2_ID")
    private Team team2;

    @Column(name = "SCORE1")
    private Integer score1;

    @Column(name = "SCORE2")
    private Integer score2;

    @Temporal(TemporalType.DATE)
    @Column(name = "MATCH_DATE")
    private Date matchDate;


<<<<<<< HEAD
    // This Boolean attribute  is to determine wether a score is already updated or not.
    @Column(name = "SCORES_UPDATED")
    private Boolean scoresUpdated = false;

    // I used getters and setters for tracking of the scores accurately
    public Boolean getScoresUpdated() {
        return scoresUpdated;
    }

    public void setScoresUpdated(Boolean scoresUpdated) {
        this.scoresUpdated = scoresUpdated;
    }


=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public boolean isResultApplied() {
        return true;
    }

    public void setResultApplied(boolean b) {
    }
}

