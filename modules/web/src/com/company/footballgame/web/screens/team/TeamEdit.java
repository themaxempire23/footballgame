package com.company.footballgame.web.screens.team;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.Team;

import javax.inject.Inject;

@UiController("footballgame_Team.edit")
@UiDescriptor("team-edit.xml")
@EditedEntityContainer("teamDc")
@LoadDataBeforeShow
public class TeamEdit extends StandardEditor<Team> {
    @Inject
    private TextField<String> nameField;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Team team = getEditedEntity();
        if (nameField.getValue() == null || nameField.getValue().trim().isEmpty()) {
            notifications.create().withCaption("Name cannot be empty").show();
            event.preventCommit();
        }

        // How I check if there is a team with the same name
        long count = dataManager.loadValue("select count(t) from footballgame_Team t where t.name = :name and t.id <> :id", Long.class)
                .parameter("name", nameField.getValue().trim())
                .parameter("id", team.getId() != null ? team.getId() : "0")
                .one();
        if (count > 0) {
            notifications.create().withCaption("A team with this name already exists.").show();
            event.preventCommit();
        }
    }
}
