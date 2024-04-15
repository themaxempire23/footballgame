package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;

public interface FixtureService {
    String NAME = "footballgame_FixtureService";

    void generateFixtures(); // Method to generate fixtures

    void updateFixtureAndLogTable(Fixture fixture);

    void refreshFixturesBasedOnExistingTeams();


}
