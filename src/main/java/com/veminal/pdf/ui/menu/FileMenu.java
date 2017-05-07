package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.file.ExitAction;
import com.veminal.pdf.actions.file.SaveFileAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.file.CreateFileAction;
import com.veminal.pdf.actions.file.OpenFileAction;
import com.veminal.pdf.actions.file.SaveAsAction;

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
        MenuManager manager = new MenuManager("File");
        IEvent eventCreate = new CreateFileAction();
        IEvent eventOpen = new OpenFileAction();
        IEvent eventSave = new SaveFileAction();
        IEvent eventSaveAs = new SaveAsAction();
        IEvent eventExit = new ExitAction();
        manager.add(eventCreate.initializing());
        manager.add(new Separator());
        manager.add(eventOpen.initializing());
        manager.add(new Separator());
        manager.add(eventSave.initializing());
        manager.add(eventSaveAs.initializing());
        manager.add(new Separator());
        manager.add(eventExit.initializing());
        return manager;
    }
}
