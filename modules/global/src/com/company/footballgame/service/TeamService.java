package com.company.footballgame.service;

import com.company.footballgame.entity.Team;

import java.util.List;
import java.util.UUID;

public interface TeamService {
        String NAME = "footballgame_TeamService";

        Team createTeam(String name); // Adding a new team
<<<<<<< HEAD
        //Team removeTeam(Team team);   // Removing a team

        //Team removeTeam(String name);


        Team removeTeam(Team team);

=======
        void removeTeam(Team team);   // Removing a team
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
        Team updateTeamInfo(Team team, String newName); // Updating existing team info
        List<Team> listAllTeams(); // Getting a list of all teams in my db
        Team getTeamById(UUID teamId); // Find a team by its ID Team getTeamById(UUID teamId);

    }
