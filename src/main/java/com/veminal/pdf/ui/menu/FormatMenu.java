package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.settings.read.ReadConfig;
import com.veminal.pdf.settings.read.ReadDataFields;
import org.eclipse.jface.action.MenuManager;

import java.util.List;

/**
 * Create menu item "Format".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FormatMenu implements IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        ReadConfig<String> readFormatMenu = new ReadDataFields(path);
        MenuManager manager = new MenuManager(readFormatMenu.parse(
                "menu.format"));
        IEventList formatTitlesList = new EditActionsList();
        List<IEvent> formatList = formatTitlesList.getActionList();
        for (IEvent action: formatList) {
            ReadConfig<String> reader = new ReadDataFields(path);
            manager.add(action.initializing(reader));
        }
        formatList.clear();
        return manager;
    }
}
