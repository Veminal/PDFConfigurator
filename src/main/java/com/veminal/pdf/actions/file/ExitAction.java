package com.veminal.pdf.actions.file;

import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

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
     * @return Action
     */
    @Override
    public Action initializing() {
        return new Action() {
            @Override
            public String getText() {
                return "Exit";
            }

            @Override
            public void run() {
                final int status = 0;
                super.run();
                System.exit(status);
            }
        };
    }
}
