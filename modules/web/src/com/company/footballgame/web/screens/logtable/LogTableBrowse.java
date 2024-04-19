package com.company.footballgame.web.screens.logtable;

import com.company.footballgame.entity.Fixture;
<<<<<<< HEAD
import com.company.footballgame.service.FixtureService;
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
import com.company.footballgame.service.LeagueTableService;
//import com.company.footballgame.service.LeagueTableServiceBean;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
<<<<<<< HEAD
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.LogTable;

import javax.inject.Inject;
import java.util.List;

@UiController("footballgame_LogTable.browse")
@UiDescriptor("log-table-browse.xml")
@LookupComponent("logTablesTable")
@LoadDataBeforeShow

public class LogTableBrowse extends StandardLookup<LogTable> {
    @Inject
    private CollectionLoader<LogTable> logTablesDl;

    // Inject the service that contains the logic to update league tables.
    @Inject
    private LeagueTableService leagueTableService;


    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
<<<<<<< HEAD
    @Inject
    private CollectionContainer<LogTable> logTablesDc;
    @Inject
    private ButtonsPanel buttonsPanel;
    @Inject
    private GroupTable<LogTable> logTablesTable;
    @Inject
    private FixtureService fixtureService;
    @Inject
    private Button refreshBtn;
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7

//    public void onRefreshStandingsBtnClick() {
//        leagueTableService.refreshLeagueTable();
//        logTablesDl.load();
//    }


    //Testing this now
<<<<<<< HEAD
//    public void onRefreshStandingsBtnClick() {
//        try {
//            leagueTableService.refreshLogTablesBasedOnExistingTeams(); // Call the instance method
//            logTablesDl.load(); // Use CollectionLoader to refresh the data
//            notifications.create(Notifications.NotificationType.HUMANIZED)
//                    .withCaption("Standings refreshed & updated successfully.")
//                    .show();
//        } catch (Exception e) {
//            notifications.create(Notifications.NotificationType.ERROR)
//                    .withCaption("Failed to update standings: " + e.getMessage())
//                    .show();
//        }
//    }

    //test 3

    public void onRefreshStandingsBtnClick() {
            try {

                leagueTableService.refreshLogTablesBasedOnExistingTeams();

                logTablesDl.load();
                // Show a notification that the log tables have been successfully refreshed
                notifications.create(Notifications.NotificationType.HUMANIZED)
                        .withCaption("Standings refreshed successfully.")
                        .show();
            } catch (Exception e) {

                notifications.create(Notifications.NotificationType.ERROR)
                        .withCaption("Failed to refresh standings: " + e.getMessage())
                        .show();
            }
        }
=======
    public void onRefreshStandingsBtnClick() {
        try {
            leagueTableService.refreshLeagueTable();
            logTablesDl.load();
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Standings updated successfully")
                    .show();
        } catch (Exception e) {
            notifications.create(Notifications.NotificationType.ERROR)
                    .withCaption("Failed to update standings: " + e.getMessage())
                    .show();
        }
    }
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7




<<<<<<< HEAD
    }
=======
}
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
