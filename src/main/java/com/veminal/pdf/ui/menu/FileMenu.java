package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.FileActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.StringReader;
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
     * Config reader.
     */
    private final ReadConfig readFileMenu;

    /**
     * Constructor of class.
     * Inject file menu
     *
     * @param readMenu the ReadConfig
     */
    @Inject
    public FileMenu(@StringReader final ReadConfig readMenu) {
        this.readFileMenu = readMenu;
    }

    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readFileMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readFileMenu.parse("menu.file"));
        IEventList fileTitlesList = new FileActionsList();
        List<IEvent> fileList = fileTitlesList.getActionList();
        for (IEvent action : fileList) {
            readFileMenu.readPath(path);
            manager.add(action.initializing(readFileMenu));
        }
        fileList.clear();
        return manager;
    }
}
