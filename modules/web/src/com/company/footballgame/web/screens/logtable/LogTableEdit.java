package com.company.footballgame.web.screens.logtable;

import com.haulmont.cuba.gui.screen.*;
import com.company.footballgame.entity.LogTable;

@UiController("footballgame_LogTable.edit")
@UiDescriptor("log-table-edit.xml")
@EditedEntityContainer("logTableDc")
@LoadDataBeforeShow
public class LogTableEdit extends StandardEditor<LogTable> {
}