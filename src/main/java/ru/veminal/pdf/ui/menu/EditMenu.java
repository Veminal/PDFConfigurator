package ru.veminal.pdf.ui.menu;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import ru.veminal.pdf.actions.IEvent;
import ru.veminal.pdf.actions.edit.CopyAction;
import ru.veminal.pdf.actions.edit.CutAction;
import ru.veminal.pdf.actions.edit.DeleteAction;
import ru.veminal.pdf.actions.edit.FontAction;
import ru.veminal.pdf.actions.edit.PasteAction;
import ru.veminal.pdf.actions.edit.SelectAllAction;
import ru.veminal.pdf.actions.edit.SettingAction;
import ru.veminal.pdf.actions.edit.UndoSelectionAction;

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
        MenuManager manager = new MenuManager("Edit");
        IEvent cutEvent = new CutAction();
        IEvent copyEvent = new CopyAction();
        IEvent pasteAction = new PasteAction();
        IEvent deleteAction = new DeleteAction();
        IEvent selectAction = new SelectAllAction();
        IEvent undoSelectAction = new UndoSelectionAction();
        IEvent settingsAction = new SettingAction();
        IEvent fontAction = new FontAction();
        manager.add(cutEvent.initializing());
        manager.add(copyEvent.initializing());
        manager.add(pasteAction.initializing());
        manager.add(deleteAction.initializing());
        manager.add(new Separator());
        manager.add(fontAction.initializing());
        manager.add(new Separator());
        manager.add(selectAction.initializing());
        manager.add(undoSelectAction.initializing());
        manager.add(new Separator());
        manager.add(settingsAction.initializing());
        return manager;
    }
}
