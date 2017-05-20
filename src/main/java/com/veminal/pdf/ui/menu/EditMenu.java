package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
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
     * Constructor of class.
     * Inject file menu
     *
     * @param readMenu the ReadConfig
     */
    @Inject
    public EditMenu(@StringReader final ReadConfig readMenu) {
        this.readEditMenu = readMenu;
    }

    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readEditMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readEditMenu.parse("menu.edit"));
        IEventList editTitlesList = new EditActionsList();
        List<IEvent> editList = editTitlesList.getActionList();
        for (IEvent action : editList) {
            readEditMenu.readPath(path);
            manager.add(action.initializing(readEditMenu));
        }
        editList.clear();
        return manager;
    }
}
