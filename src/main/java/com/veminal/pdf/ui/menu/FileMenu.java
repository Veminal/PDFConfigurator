package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.menu.file.CreateFileAction;
import com.veminal.pdf.actions.menu.file.ExitAction;
import com.veminal.pdf.actions.menu.file.OpenFileAction;
import com.veminal.pdf.actions.menu.file.SaveAsAction;
import com.veminal.pdf.actions.menu.file.SaveFileAction;
import com.veminal.pdf.settings.read.ReadDataFile;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

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
        final String path = "dictionaries/dictionary.json";
        ReadSettings<String> readFileMenu = new ReadDataFile(path);
        MenuManager manager = new MenuManager(readFileMenu.parse("menu.file"));
        IEvent eventCreate = new CreateFileAction();
        IEvent eventOpen = new OpenFileAction();
        IEvent eventSave = new SaveFileAction();
        IEvent eventSaveAs = new SaveAsAction();
        IEvent eventExit = new ExitAction();
        ReadSettings<String> readCreate = new ReadDataFile(path);
        manager.add(eventCreate.initializing(readCreate));
        manager.add(new Separator());
        ReadSettings<String> readOpen = new ReadDataFile(path);
        manager.add(eventOpen.initializing(readOpen));
        manager.add(new Separator());
        ReadSettings<String> readSave = new ReadDataFile(path);
        manager.add(eventSave.initializing(readSave));
        ReadSettings<String> readSaveAs = new ReadDataFile(path);
        manager.add(eventSaveAs.initializing(readSaveAs));
        manager.add(new Separator());
        ReadSettings<String> readExit = new ReadDataFile(path);
        manager.add(eventExit.initializing(readExit));
        return manager;
    }
}
