package com.veminal.pdf.actions.edit;

import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Paste".
 *
 * @author Veminal
 * @version 1.0
 */
public final class PasteAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    @Override
    public Action initializing(final ReadSettings menuItemsName) {
        return new Action((String) menuItemsName.parse("paste")) {
        };
    }
}
