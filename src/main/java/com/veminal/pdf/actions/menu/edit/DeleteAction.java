package com.veminal.pdf.actions.menu.edit;

import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Delete".
 *
 * @author Veminal
 * @author 1.0
 */
public final class DeleteAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("delete")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
