package net.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.core.annotations.TableContext;
import org.eclipse.jface.action.MenuManager;

import java.util.List;

/**
 * Table context menu creator.
 *
 * @author Veminal
 * @version 1.0
 */
public final class TableContextMenu implements IMenu {
    /**
     * Config reader.
     */
    private final ReadConfig contextConfig;
    /**
     * Help menu list.
     */
    private final IEventList popupList;
    /**
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     * Inject popup menu.
     *
     * @param config     the ReadConfig
     * @param list       the IEventList
     * @param pathToFile the String
     */
    @Inject
    public TableContextMenu(@StringReader final ReadConfig config,
                            @TableContext final IEventList list,
                            final String pathToFile) {
        this.contextConfig = config;
        this.popupList = list;
        this.path = pathToFile;
    }

    @Override
    public MenuManager initial() {
        MenuManager manager = new MenuManager();
        List<IEvent> listMenu = popupList.getActionList();
        for (IEvent action : listMenu) {
            contextConfig.readPath(path);
            manager.add(action.initializing(contextConfig));
        }
        listMenu.clear();
        return manager;
    }
}
