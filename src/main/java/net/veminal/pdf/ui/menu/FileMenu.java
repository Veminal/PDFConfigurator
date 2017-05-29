package net.veminal.pdf.ui.menu;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.FileList;
import net.veminal.pdf.core.annotations.StringReader;
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
     * File menu list.
     */
    private final IEventList files;
    /**
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     *
     * @param readMenu   the ReadConfig
     * @param listFiles  the IEventList
     * @param pathToFile the String
     */
    @Inject
    public FileMenu(@StringReader final ReadConfig readMenu,
                    @FileList final IEventList listFiles,
                    final String pathToFile) {
        this.readFileMenu = readMenu;
        this.files = listFiles;
        this.path = pathToFile;
    }

    @Override
    public MenuManager initial() {
        readFileMenu.readPath(path);
        MenuManager manager = new MenuManager(
                (String) readFileMenu.parse("menu.file"));
        List<IEvent> fileList = files.getActionList();
        for (IEvent action : fileList) {
            readFileMenu.readPath(path);
            manager.add(action.initializing(readFileMenu));
        }
        fileList.clear();
        return manager;
    }
}
