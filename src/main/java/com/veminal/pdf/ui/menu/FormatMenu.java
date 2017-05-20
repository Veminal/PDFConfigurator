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
 * Create menu item "Format".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FormatMenu implements IMenu {
    /**
     * Config reader.
     */
    private final ReadConfig readFormatMenu;

    /**
     * Constructor of class.
     * Inject file menu
     *
     * @param readMenu the ReadConfig
     */
    @Inject
    public FormatMenu(@StringReader final ReadConfig readMenu) {
        this.readFormatMenu = readMenu;
    }

    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readFormatMenu.readPath(path);
        MenuManager manager = new MenuManager((String) readFormatMenu.parse("menu.format"));
        IEventList formatTitlesList = new EditActionsList();
        List<IEvent> formatList = formatTitlesList.getActionList();
        for (IEvent action : formatList) {
            readFormatMenu.readPath(path);
            manager.add(action.initializing(readFormatMenu));
        }
        formatList.clear();
        return manager;
    }
}
