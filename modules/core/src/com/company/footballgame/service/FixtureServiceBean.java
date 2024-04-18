package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;
import com.company.footballgame.entity.Team;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service(FixtureService.NAME)
public class FixtureServiceBean implements FixtureService {

    @Inject
    private DataManager dataManager;
    @Inject
    private LeagueTableService leagueTableService;



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
//        fixture = dataManager.commit(fixture);
//
//        leagueTableService.updateLeagueTable(fixture);

        // Here I get to reload the fixture from the database to ensure it's managed and has the latest state regarding my teams and etc
        fixture = dataManager.reload(fixture, "fixture-view");


        if (Boolean.TRUE.equals(fixture.getScoresUpdated())) {

            return;
        }


        leagueTableService.updateLeagueTable(fixture);


        fixture.setScoresUpdated(true);


        dataManager.commit(fixture);
    }


    @Override
    @Transactional
    public void refreshFixturesBasedOnExistingTeams() {

            // Loading all my existing teams.
            List<Team> existingTeams = dataManager.load(Team.class)
                    .query("select e from footballgame_Team e")
                    .view("team-view") // Use the team-view if it includes all necessary attributes
                    .list();

            // Fetching all my fixtures using the fixture-view that includes my team1 and team2.
            List<Fixture> allFixtures = dataManager.load(Fixture.class)
                    .query("select e from footballgame_Fixture e")
                    .view("fixture-view") // Specify the fixture-view here
                    .list();

            // How I filter and remove fixtures involving non-existent teams.
            allFixtures.stream()
                    .filter(fixture -> !existingTeams.contains(fixture.getTeam1()) || !existingTeams.contains(fixture.getTeam2()))
                    .forEach(dataManager::remove);
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
        fixture.setMatchDate(calendar.getTime()); // Setting the match date
        dataManager.commit(fixture);
    }
}
