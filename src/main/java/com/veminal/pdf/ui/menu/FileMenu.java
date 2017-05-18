package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.FileActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.settings.read.ReadConfig;
import com.veminal.pdf.settings.read.ReadDataFields;
import org.eclipse.jface.action.MenuManager;

import java.util.List;

/**
 * Create menu item "File".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FileMenu implements IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        ReadConfig<String> readFileMenu = new ReadDataFields(path);
        MenuManager manager = new MenuManager(readFileMenu.parse("menu.file"));
        IEventList fileTitlesList = new FileActionsList();
        List<IEvent> fileList = fileTitlesList.getActionList();
        for (IEvent action: fileList) {
            ReadConfig<String> reader = new ReadDataFields(path);
            manager.add(action.initializing(reader));
        }
        fileList.clear();
        return manager;
    }
}
