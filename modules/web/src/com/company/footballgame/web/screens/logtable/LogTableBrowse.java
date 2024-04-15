package com.company.footballgame.web.screens.logtable;

import com.company.footballgame.entity.Fixture;
import com.company.footballgame.service.LeagueTableService;
//import com.company.footballgame.service.LeagueTableServiceBean;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
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

//    public void onRefreshStandingsBtnClick() {
//        leagueTableService.refreshLeagueTable();
//        logTablesDl.load();
//    }


    //Testing this now
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




}