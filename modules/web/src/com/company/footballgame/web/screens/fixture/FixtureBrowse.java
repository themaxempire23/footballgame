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
}
