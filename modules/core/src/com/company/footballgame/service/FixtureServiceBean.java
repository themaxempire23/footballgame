package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;
import com.company.footballgame.entity.Team;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;

@Service(FixtureService.NAME)
public class FixtureServiceBean implements FixtureService {

    @Inject
    private DataManager dataManager;
    @Inject
    private LeagueTableService leagueTableService;

    //private Date seasonStartDate; // This should be initialized to your league's start date.

    @Override
    public void generateFixtures() {
        List<Team> teams = getAllTeams();
        if (teams.size() < 2) {
            throw new IllegalStateException("Not enough teams to generate fixtures.");
        }
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(seasonStartDate); // Set to the start of the season

        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                // Pass the calendar instance to manage the match date
                createAndSaveFixture(teams.get(i), teams.get(j), calendar);
                // Increment the date by one week for the next fixture
                calendar.add(Calendar.DATE, 7);
            }
        }
    }

    @Override
    public void updateFixtureAndLogTable(Fixture fixture) {
        fixture = dataManager.commit(fixture);

        leagueTableService.updateLeagueTable(fixture);
    }

    private List<Team> getAllTeams() {
        return dataManager.load(Team.class)
                .query("select t from footballgame_Team t")
                .list();
    }

    private void createAndSaveFixture(Team team1, Team team2, Calendar calendar) {
        Fixture fixture = dataManager.create(Fixture.class);
        fixture.setTeam1(team1);
        fixture.setTeam2(team2);
        fixture.setScore1(null); // Match has not been played yet
        fixture.setScore2(null); // Match has not been played yet
        fixture.setMatchDate(calendar.getTime()); // Set the match date
        dataManager.commit(fixture);
    }
}
