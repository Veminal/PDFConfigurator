package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.menu.edit.DeleteAction;
import com.veminal.pdf.settings.read.ReadDataFile;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.MenuManager;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.menu.edit.CopyAction;
import com.veminal.pdf.actions.menu.edit.CutAction;
import com.veminal.pdf.actions.menu.edit.FontAction;
import com.veminal.pdf.actions.menu.edit.PasteAction;
import com.veminal.pdf.actions.menu.edit.SelectAllAction;
import com.veminal.pdf.actions.menu.edit.SettingsAction;
import com.veminal.pdf.actions.menu.edit.UndoSelectionAction;
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
        ReadSettings<String> readEditMenu = new ReadDataFile(path);
        MenuManager manager = new MenuManager(readEditMenu.parse("menu.edit"));
        IEvent cutEvent = new CutAction();
        IEvent copyEvent = new CopyAction();
        IEvent pasteAction = new PasteAction();
        IEvent deleteAction = new DeleteAction();
        IEvent selectAction = new SelectAllAction();
        IEvent undoSelectAction = new UndoSelectionAction();
        IEvent settingsAction = new SettingsAction();
        IEvent fontAction = new FontAction();
        ReadSettings<String> readCut = new ReadDataFile(path);
        manager.add(cutEvent.initializing(readCut));
        ReadSettings<String> readCopy = new ReadDataFile(path);
        manager.add(copyEvent.initializing(readCopy));
        ReadSettings<String> readPaste = new ReadDataFile(path);
        manager.add(pasteAction.initializing(readPaste));
        ReadSettings<String> readDel = new ReadDataFile(path);
        manager.add(deleteAction.initializing(readDel));
        manager.add(new Separator());
        ReadSettings<String> readFont = new ReadDataFile(path);
        manager.add(fontAction.initializing(readFont));
        manager.add(new Separator());
        ReadSettings<String> readSelect = new ReadDataFile(path);
        manager.add(selectAction.initializing(readSelect));
        ReadSettings<String> readUndoSelect = new ReadDataFile(path);
        manager.add(undoSelectAction.initializing(readUndoSelect));
        manager.add(new Separator());
        ReadSettings<String> readSettings = new ReadDataFile(path);
        manager.add(settingsAction.initializing(readSettings));
        return manager;
    }
}
