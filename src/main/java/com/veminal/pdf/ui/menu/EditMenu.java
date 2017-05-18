package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.settings.read.ReadDataFields;
import com.veminal.pdf.settings.read.ReadConfig;
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
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        ReadConfig<String> readEditMenu = new ReadDataFields(path);
        MenuManager manager = new MenuManager(readEditMenu.parse("menu.edit"));
        IEventList editTitlesList = new EditActionsList();
        List<IEvent> editList = editTitlesList.getActionList();
        for (IEvent action: editList) {
            ReadConfig<String> reader = new ReadDataFields(path);
            manager.add(action.initializing(reader));
        }
        editList.clear();
        return manager;
    }
}
