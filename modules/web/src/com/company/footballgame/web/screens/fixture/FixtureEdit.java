package com.company.footballgame.web.screens.fixture;

import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.Fixture;

@UiController("footballgame_Fixture.edit")
@UiDescriptor("fixture-edit.xml")
@EditedEntityContainer("fixtureDc")
@LoadDataBeforeShow
public class FixtureEdit extends StandardEditor<Fixture> {

}