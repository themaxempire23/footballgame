//package com.company.footballgame.web.screens.fixture;
//
//import com.haulmont.cuba.gui.screen.*;
//import com.company.footballgame.entity.Fixture;
//
//@UiController("footballgame_Fixture.browse")
//@UiDescriptor("fixture-browse.xml")
//@LookupComponent("fixturesTable")
//@LoadDataBeforeShow
//public class FixtureBrowse extends StandardLookup<Fixture> {
//}

package com.company.footballgame.web.screens.fixture;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.Fixture;
import com.company.footballgame.service.FixtureService;
import com.haulmont.cuba.gui.model.CollectionLoader;

import javax.inject.Inject;

@UiController("footballgame_Fixture.browse")
@UiDescriptor("fixture-browse.xml")
@LookupComponent("fixturesTable")
@LoadDataBeforeShow
public class FixtureBrowse extends StandardLookup<Fixture> {
    @Inject
    private FixtureService fixtureService;
    @Inject
    private GroupTable<Fixture> fixturesTable;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<Fixture> fixturesDl;
    @Inject
    private Button refreshBtn;

    // Method triggered by clicking "Generate Fixtures" button
    public void onGenerateFixturesBtnClick() {
        try {
            fixtureService.generateFixtures();
            fixturesDl.load();  // Corrected: using the injected loader
            notifications.create().withCaption("Fixtures generated successfully.").show();
        } catch (Exception e) {
            notifications.create().withCaption("Error generating fixtures: " + e.getMessage()).show();
        }
    }

    public void onUpdateScoresBtnClick() {
        Fixture selectedFixture = fixturesTable.getSingleSelected();
        if (selectedFixture != null) {
            try {
                fixtureService.updateFixtureAndLogTable(selectedFixture);
                notifications.create().withCaption("Scores updated successfully.").show();
                fixturesDl.load(); // Reload the fixtures to reflect any changes
            } catch (Exception e) {
                notifications.create().withCaption("Error updating scores: " + e.getMessage()).show();
            }
        } else {
            notifications.create().withCaption("Please select a fixture to update.").show();
        }
    }

//    @Subscribe("refreshBtn")
//    public void onRefreshBtnClick(Button.ClickEvent event) {
//        try {
//            // Remove any fixtures that include teams that are no longer present in the database.
//            fixtureService.refreshFixturesBasedOnExistingTeams();
//            // Reload the fixtures list to show only fixtures for existing teams.
//            fixturesDl.load();
//            notifications.create().withCaption("Fixtures refreshed successfully.").show();
//        } catch (Exception e) {
//            notifications.create().withCaption("Error refreshing fixtures: " + e.getMessage()).show();
//        }
//    }

    public void onRefreshBtnClick() {
//       System.out.println("Refresh button clicked"); // Just for testing purposes
//        notifications.create().withCaption("Button clicked!").show();
        try {
            // Remove any fixtures that include teams that are no longer present in the database.
            fixtureService.refreshFixturesBasedOnExistingTeams();
            // Reload the fixtures list to show only fixtures for existing teams.
            fixturesDl.load();
            notifications.create().withCaption("Fixtures refreshed successfully.").show();
        } catch (Exception e) {
            notifications.create().withCaption("Error refreshing fixtures: " + e.getMessage()).show();
       }
    }
}


