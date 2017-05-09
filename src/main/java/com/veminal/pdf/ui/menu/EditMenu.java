package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.edit.DeleteAction;
import com.veminal.pdf.settings.read.ReadDataMenu;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.MenuManager;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.edit.CopyAction;
import com.veminal.pdf.actions.edit.CutAction;
import com.veminal.pdf.actions.edit.FontAction;
import com.veminal.pdf.actions.edit.PasteAction;
import com.veminal.pdf.actions.edit.SelectAllAction;
import com.veminal.pdf.actions.edit.SettingsAction;
import com.veminal.pdf.actions.edit.UndoSelectionAction;
import org.eclipse.jface.action.Separator;

/**
 * Create menu item "Edit".
 *
 * @author Veminal
 * @version 1.0
 */
public final class EditMenu implements IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        final String path = "dictionaries/dictionary.json";
        ReadSettings<String> readEditMenu = new ReadDataMenu(path);
        MenuManager manager = new MenuManager(readEditMenu.parse("menu.edit"));
        IEvent cutEvent = new CutAction();
        IEvent copyEvent = new CopyAction();
        IEvent pasteAction = new PasteAction();
        IEvent deleteAction = new DeleteAction();
        IEvent selectAction = new SelectAllAction();
        IEvent undoSelectAction = new UndoSelectionAction();
        IEvent settingsAction = new SettingsAction();
        IEvent fontAction = new FontAction();
        ReadSettings<String> readCut = new ReadDataMenu(path);
        manager.add(cutEvent.initializing(readCut));
        ReadSettings<String> readCopy = new ReadDataMenu(path);
        manager.add(copyEvent.initializing(readCopy));
        ReadSettings<String> readPaste = new ReadDataMenu(path);
        manager.add(pasteAction.initializing(readPaste));
        ReadSettings<String> readDel = new ReadDataMenu(path);
        manager.add(deleteAction.initializing(readDel));
        manager.add(new Separator());
        ReadSettings<String> readFont = new ReadDataMenu(path);
        manager.add(fontAction.initializing(readFont));
        manager.add(new Separator());
        ReadSettings<String> readSelect = new ReadDataMenu(path);
        manager.add(selectAction.initializing(readSelect));
        ReadSettings<String> readUndoSelect = new ReadDataMenu(path);
        manager.add(undoSelectAction.initializing(readUndoSelect));
        manager.add(new Separator());
        ReadSettings<String> readSettings = new ReadDataMenu(path);
        manager.add(settingsAction.initializing(readSettings));
        return manager;
    }
}
