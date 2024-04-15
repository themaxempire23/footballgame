package com.company.footballgame.service;

import com.company.footballgame.entity.Team;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(TeamService.NAME)
public class TeamServiceBean implements TeamService {

    @Inject
    private DataManager dataManager;

    @Override
    public Team createTeam(String name) {
        // Create a new team instance and set the name
        Team team = dataManager.create(Team.class);
        team.setName(name);
        // Save the new team to the database
        return dataManager.commit(team);
    }

    @Override
    public void removeTeam(Team team) {
        // Remove the team from the database
        dataManager.remove(team);
    }

    @Override
    public Team updateTeamInfo(Team team, String newName) {
        // Load the team from the database, update the name, and save
        Team managedTeam = dataManager.reload(team, "team-view"); // 'team-view' should include all necessary attributes
        managedTeam.setName(newName);
        return dataManager.commit(managedTeam);
    }

    @Override
    public List<Team> listAllTeams() {
        // Retrieve all team entities from the database
        return dataManager.load(Team.class)
                .query("select e from footballgame_Team e")
                .list();
    }

    @Override
    public Team getTeamById(UUID teamId) {
        // Find a team by its ID
        return dataManager.load(Team.class)
                .id(teamId)
                .optional()
                .orElse(null);
    }
}
