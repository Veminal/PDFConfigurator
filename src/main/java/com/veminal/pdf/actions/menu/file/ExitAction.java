package com.veminal.pdf.actions.menu.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotation.NotUsed;
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
            /**
             * The default implementation of this <code>IAction</code> method does
             * nothing. Subclasses should override this method if they do not need
             * information from the triggering event, or override
             * <code>runWithEvent(Event)</code> if they do.
             */
            @Override
            public void run() {
                final int status = -1;
                System.exit(status);
            }
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
