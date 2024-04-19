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

<<<<<<< HEAD
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
=======
import com.haulmont.cuba.gui.Notifications;
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.Fixture;
import com.company.footballgame.service.FixtureService;
import com.haulmont.cuba.gui.model.CollectionLoader;

import javax.inject.Inject;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7

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
<<<<<<< HEAD
    @Inject
    private Button refreshBtn;
    @Inject
    private DataManager dataManager;
=======
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7

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
<<<<<<< HEAD

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


    //This is how my update button works all
    public void onUpdateAllScoresBtnClick() {
        {
            // Load fixtures that haven't had their scores updated.
            List<Fixture> fixturesToUpdate = dataManager.load(Fixture.class)
                    .query("select f from footballgame_Fixture f where f.scoresUpdated = false")
                    .view("fixture-view")
                    .list();

            for (Fixture fixture : fixturesToUpdate) {
                try {
                    // Use the existing service method to update fixtures and corresponding log table entries.
                    fixtureService.updateFixtureAndLogTable(fixture);
                } catch (Exception e) {
                    notifications.create()
                            .withCaption("Error updating fixture scores: " + e.getMessage())
                            .show();
                    // If an error occurs, stop further processing.
                    return;
                }
            }

            // Reload fixtures to show the updated statuses.
            fixturesDl.load();
            notifications.create()
                    .withCaption("All scores updated successfully.")
                    .show();
        }
    }

}


=======
}
>>>>>>> be7c31e4ed75bceeb8a0212d76dd8162e99b26e7
