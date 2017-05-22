package com.veminal.pdf.actions.menu.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Exit".
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExitAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("exit")) {
            @Override
            public void run() {
                final int status = -1;
                System.exit(status);
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
