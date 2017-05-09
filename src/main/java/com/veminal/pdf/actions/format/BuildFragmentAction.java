package com.veminal.pdf.actions.format;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.settings.read.ReadDataMenu;
import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Build fragments".
 *
 * @author Veminal
 * @version 1.0
 */
public final class BuildFragmentAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    @Override
    public Action initializing(final ReadSettings menuItemsName) {
        return new Action((String) menuItemsName.parse("build.fragments")) {
        };
    }
}
