package com.veminal.pdf.actions.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Exit".
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExitAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    @Override
    public Action initializing(final ReadSettings menuItemsName) {
        return new Action((String) menuItemsName.parse("exit")) {
        };
    }
}
