package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.EditList;
import com.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.action.MenuManager;

import java.util.List;

/**
 * Create menu item "Edit".
 *
 * @author Veminal
 * @version 1.0
 */
public final class EditMenu implements IMenu {
    /**
     * Config reader.
     */
    private final ReadConfig readEditMenu;
    /**
     * Edit menu list.
     */
    private final IEventList edit;

    /**
     * Constructor of class.
     *
     * @param readMenu the ReadConfig
     * @param listEdit the IEventList
     */
    @Inject
    public EditMenu(@StringReader final ReadConfig readMenu,
                    @EditList final IEventList listEdit) {
        this.readEditMenu = readMenu;
        this.edit = listEdit;
    }

    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readEditMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readEditMenu.parse("menu.edit"));
        List<IEvent> editList = edit.getActionList();
        for (IEvent action : editList) {
            readEditMenu.readPath(path);
            manager.add(action.initializing(readEditMenu));
        }
        editList.clear();
        return manager;
    }
}
