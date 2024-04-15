package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;
import com.company.footballgame.entity.LogTable;
import com.company.footballgame.entity.Team;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service(LeagueTableServiceBean.NAME)
public class LeagueTableServiceBean implements LeagueTableService {

    @Inject
    private DataManager dataManager;
    @Inject
    private LeagueTableService leagueTableService;


    @Override
    @Transactional
    public void updateLeagueTable(Fixture fixture) {
        Integer score1 = fixture.getScore1();
        Integer score2 = fixture.getScore2();

        // Ensure that the scores are not null, which indicates that the match has been played.
        if (score1 == null || score2 == null) {
            // No scores to update from.
            return;
        }

        Team team1 = fixture.getTeam1();
        Team team2 = fixture.getTeam2();

        // Get or create the LogTable entries for each team.
        LogTable logTableTeam1 = getOrCreateLogTable(team1);
        LogTable logTableTeam2 = getOrCreateLogTable(team2);

        // Apply the match results to update the standings.
        if (score1 > score2) {
            // Team 1 wins
            logTableTeam1.setWins(logTableTeam1.getWins() + 1);
            logTableTeam1.setPoints(logTableTeam1.getPoints() + 3);
            logTableTeam2.setLosses(logTableTeam2.getLosses() + 1);
        } else if (score1 < score2) {
            // Team 2 wins
            logTableTeam2.setWins(logTableTeam2.getWins() + 1);
            logTableTeam2.setPoints(logTableTeam2.getPoints() + 3);
            logTableTeam1.setLosses(logTableTeam1.getLosses() + 1);
        } else {
            // Draw
            logTableTeam1.setDraws(logTableTeam1.getDraws() + 1);
            logTableTeam1.setPoints(logTableTeam1.getPoints() + 1);
            logTableTeam2.setDraws(logTableTeam2.getDraws() + 1);
            logTableTeam2.setPoints(logTableTeam2.getPoints() + 1);
        }

        // Update goals for and goals against.
        logTableTeam1.setGoalsFor(logTableTeam1.getGoalsFor() + score1);
        logTableTeam1.setGoalsAgainst(logTableTeam1.getGoalsAgainst() + score2);
        logTableTeam2.setGoalsFor(logTableTeam2.getGoalsFor() + score2);
        logTableTeam2.setGoalsAgainst(logTableTeam2.getGoalsAgainst() + score1);

        // Commit the changes to the database.
        dataManager.commit(logTableTeam1);
        dataManager.commit(logTableTeam2);


    }



    @Override
    @Transactional
    public void initializeLogTable() {
        //Method to fetch all the teams from the Team list in team entity
        List<Team> teams = dataManager.load(Team.class)
                .query("select e from footballgame_Team e")
                .view("team-view")
                .list();

        // How this method will check for existing LogTable entries and create if neccesary
        for (Team team : teams) {
            long existingEntries = dataManager.loadValue(
                            "select count(l) from footballgame_LogTable l where l.team = :team", Long.class)
                    .parameter("team", team)
                    .one();


            if (existingEntries == 0) {
                LogTable logTableEntry = dataManager.create(LogTable.class);
                logTableEntry.setTeam(team);

                //Seting intial values for the table
                logTableEntry.setWins(0);
                logTableEntry.setLosses(0);
                logTableEntry.setDraws(0);
                logTableEntry.setGoalsFor(0);
                logTableEntry.setGoalsAgainst(0);
                logTableEntry.setPoints(0);
                dataManager.commit(logTableEntry);
            }
        }
    }

    //Testing refresh button
//    @Override
//    @Transactional
//    public void refreshLeagueTable() {
//        List<Fixture> fixtures = dataManager.load(Fixture.class)
//                .query("select e from footballgame_Fixture e")
//                .list();
//
//        for (Fixture fixture : fixtures) {
//            updateLeagueTable(fixture);  // This method processes each fixture
//        }
//    }




    @Override
    @Transactional
    public void refreshLeagueTable() {//I made the current change here
        List<Fixture> fixtures = dataManager.load(Fixture.class)
                .query("select f from footballgame_Fixture f where f.score1 is not null and f.score2 is not null")
                .view("fixture-view")
                .list();

        for (Fixture fixture : fixtures) {
            if (!fixture.isResultApplied()){
                updateLeagueTable(fixture);
                fixture.setResultApplied(true);
                dataManager.commit(fixture);
            }
        }
    }

    @Override
    public void updateFixtureAndLogTable(Fixture fixture) {
        Fixture managedFixture = dataManager.commit(fixture);
        updateLeagueTable(managedFixture);
    }


    private LogTable getOrCreateLogTable(Team team) {
        LogTable logTable = dataManager.load(LogTable.class)
                .query("select l from footballgame_LogTable l where l.team = :team")
                .parameter("team", team)
                .view("logTable-view")
                .optional()
                .orElseGet(() -> {
                    LogTable newLogTable = dataManager.create(LogTable.class);
                    newLogTable.setTeam(team);
                    newLogTable.setWins(0);
                    newLogTable.setLosses(0);
                    newLogTable.setDraws(0);
                    newLogTable.setGoalsFor(0);
                    newLogTable.setGoalsAgainst(0);
                    newLogTable.setPoints(0);
                    return newLogTable;
                });
        return logTable;
    }
}
