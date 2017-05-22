package com.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.FormatList;
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
     * Format menu list.
     */
    private final IEventList format;

    /**
     * Constructor of class.
     *
     * @param readMenu the ReadConfig
     * @param listFormat the IEventList
     */
    @Inject
    public FormatMenu(@StringReader final ReadConfig readMenu,
                      @FormatList final IEventList listFormat) {
        this.readFormatMenu = readMenu;
        this.format = listFormat;
    }

    @Override
    public MenuManager initial() {
        final String path = "dictionary.json";
        readFormatMenu.readPath(path);
        MenuManager manager = new MenuManager((String)
                readFormatMenu.parse("menu.format"));
        List<IEvent> formatList = format.getActionList();
        for (IEvent action : formatList) {
            readFormatMenu.readPath(path);
            manager.add(action.initializing(readFormatMenu));
        }
        formatList.clear();
        return manager;
    }
}
