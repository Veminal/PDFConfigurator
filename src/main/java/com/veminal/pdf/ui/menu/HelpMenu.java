package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.HelpList;
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
     * Help menu list.
     */
    private final IEventList help;

    /**
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     * Inject file menu
     *
     * @param readMenu   the ReadConfig
     * @param listHelp   the IEventList
     * @param pathToFile the String
     */
    @Inject
    public HelpMenu(@StringReader final ReadConfig readMenu,
                    @HelpList final IEventList listHelp,
                    final String pathToFile) {
        this.readHelpMenu = readMenu;
        this.help = listHelp;
        this.path = pathToFile;
    }

    @Override
    public MenuManager initial() {
        readHelpMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readHelpMenu.parse("menu.help"));
        List<IEvent> helpList = help.getActionList();
        for (IEvent action : helpList) {
            readHelpMenu.readPath(path);
            manager.add(action.initializing(readHelpMenu));
        }
        helpList.clear();
        return manager;
    }
}
