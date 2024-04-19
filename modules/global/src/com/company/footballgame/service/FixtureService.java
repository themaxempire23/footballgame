package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;

public interface FixtureService {
    String NAME = "footballgame_FixtureService";

    void generateFixtures(); // Method to generate fixtures

    void updateFixtureAndLogTable(Fixture fixture);

<<<<<<< HEAD
    void refreshFixturesBasedOnExistingTeams();

=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7

}
