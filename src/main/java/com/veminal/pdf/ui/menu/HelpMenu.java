package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.HelpActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.settings.read.ReadConfig;
import com.veminal.pdf.settings.read.ReadDataFields;
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
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        ReadConfig<String> readHelpMenu = new ReadDataFields(path);
        MenuManager manager = new MenuManager(readHelpMenu.parse("menu.help"));
        IEventList helpTitlesList = new HelpActionsList();
        List<IEvent> helpList = helpTitlesList.getActionList();
        for (IEvent action: helpList) {
            ReadConfig<String> reader = new ReadDataFields(path);
            manager.add(action.initializing(reader));
        }
        helpList.clear();
        return manager;
    }
}
