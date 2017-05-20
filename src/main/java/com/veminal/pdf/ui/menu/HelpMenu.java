package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.HelpActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.action.MenuManager;

import java.util.List;

/**
 * Create menu item "Help".
 *
 * @author Veminal
 * @version 1.0
 */
public final class HelpMenu implements IMenu {
    /**
     * Config reader.
     */
    private final ReadConfig readHelpMenu;

    /**
     * Constructor of class.
     * Inject file menu
     *
     * @param readMenu the ReadConfig
     */
    @Inject
    public HelpMenu(@StringReader final ReadConfig readMenu) {
        this.readHelpMenu = readMenu;
    }

    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readHelpMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readHelpMenu.parse("menu.help"));
        IEventList helpTitlesList = new HelpActionsList();
        List<IEvent> helpList = helpTitlesList.getActionList();
        for (IEvent action : helpList) {
            readHelpMenu.readPath(path);
            manager.add(action.initializing(readHelpMenu));
        }
        helpList.clear();
        return manager;
    }
}
