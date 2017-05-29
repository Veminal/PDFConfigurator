package net.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.FormatList;
import net.veminal.pdf.core.annotations.StringReader;
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
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     *
     * @param readMenu   the ReadConfig
     * @param listFormat the IEventList
     * @param pathToFile the String
     */
    @Inject
    public FormatMenu(@StringReader final ReadConfig readMenu,
                      @FormatList final IEventList listFormat,
                      final String pathToFile) {
        this.readFormatMenu = readMenu;
        this.format = listFormat;
        this.path = pathToFile;
    }

    @Override
    public MenuManager initial() {
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
