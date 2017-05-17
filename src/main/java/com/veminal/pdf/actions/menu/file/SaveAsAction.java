package com.veminal.pdf.actions.menu.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Save As...".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SaveAsAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    @Override
    public Action initializing(final ReadSettings menuItemsName) {
        return new Action((String) menuItemsName.parse("save.as")) {
        };
    }

    /**
     * Action initializing.
     *
     * @param objName of ReadSettings
     * @param path    of String
     * @return Action
     */
    @Override
    @NotUsed
    public Action initializing(final ReadSettings objName, final String path) {
        return null;
    }
}
