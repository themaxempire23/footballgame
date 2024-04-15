package com.company.footballgame.web.screens.team;

import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.Team;

@UiController("footballgame_Team.browse")
@UiDescriptor("team-browse.xml")
@LookupComponent("teamsTable")
@LoadDataBeforeShow
public class TeamBrowse extends StandardLookup<Team> {
}
