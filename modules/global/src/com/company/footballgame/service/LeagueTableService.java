package com.company.footballgame.service;

import com.company.footballgame.entity.Fixture;


public interface LeagueTableService {
    String NAME = "footballgame_LeagueTableService";

   // void updateLeagueTable();

    void updateLeagueTable(Fixture fixture);

    void initializeLogTable();



    //void refreshLeagueTable();


    //void refreshLeagueTable(LogTable logTable);


    void refreshLeagueTable();

    void updateFixtureAndLogTable(Fixture fixture);

    //void updateFixtureAndLogTable(Fixture fixture);

    // void updateFixtureAndLogTable(Fixture fixture);


    // void refreshLeagueTable(LogTable logTable);


    //void refreshLeagueTable(LogTable logTable);

    //void refreshLeagueTable(LogTable logTable);
<<<<<<< HEAD

    void refreshLogTablesBasedOnExistingTeams();
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
}

