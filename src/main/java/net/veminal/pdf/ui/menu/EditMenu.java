package net.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.EditList;
import net.veminal.pdf.core.annotations.StringReader;
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
     * Config reader.
     */
    private final ReadConfig readEditMenu;
    /**
     * Edit menu list.
     */
    private final IEventList edit;

    /**
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     *
     * @param readMenu   the ReadConfig
     * @param listEdit   the IEventList
     * @param pathToFile the String
     */
    @Inject
    public EditMenu(@StringReader final ReadConfig readMenu,
                    @EditList final IEventList listEdit,
                    final String pathToFile) {
        this.readEditMenu = readMenu;
        this.edit = listEdit;
        this.path = pathToFile;
    }

    @Override
    public MenuManager initial() {
        readEditMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readEditMenu.parse("menu.edit"));
        List<IEvent> editList = edit.getActionList();
        for (IEvent action : editList) {
            readEditMenu.readPath(path);
            manager.add(action.initializing(readEditMenu));
        }
        editList.clear();
        return manager;
    }
}
