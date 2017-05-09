package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.file.CreateFileAction;
import com.veminal.pdf.actions.file.ExitAction;
import com.veminal.pdf.actions.file.OpenFileAction;
import com.veminal.pdf.actions.file.SaveAsAction;
import com.veminal.pdf.actions.file.SaveFileAction;
import com.veminal.pdf.settings.read.ReadDataMenu;
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
        ReadSettings<String> readFileMenu = new ReadDataMenu(path);
        MenuManager manager = new MenuManager(readFileMenu.parse("menu.file"));
        IEvent eventCreate = new CreateFileAction();
        IEvent eventOpen = new OpenFileAction();
        IEvent eventSave = new SaveFileAction();
        IEvent eventSaveAs = new SaveAsAction();
        IEvent eventExit = new ExitAction();
        ReadSettings<String> readCreate = new ReadDataMenu(path);
        manager.add(eventCreate.initializing(readCreate));
        manager.add(new Separator());
        ReadSettings<String> readOpen = new ReadDataMenu(path);
        manager.add(eventOpen.initializing(readOpen));
        manager.add(new Separator());
        ReadSettings<String> readSave = new ReadDataMenu(path);
        manager.add(eventSave.initializing(readSave));
        ReadSettings<String> readSaveAs = new ReadDataMenu(path);
        manager.add(eventSaveAs.initializing(readSaveAs));
        manager.add(new Separator());
        ReadSettings<String> readExit = new ReadDataMenu(path);
        manager.add(eventExit.initializing(readExit));
        return manager;
    }
}
