package com.veminal.pdf.actions.menu.edit;

import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Select all".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SelectAllAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadConfig
     * @return Action
     */
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("select.all")) {
        };
    }

    /**
     * Action initializing.
     *
     * @param objName of ReadConfig
     * @param path    of String
     * @return Action
     */
    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
