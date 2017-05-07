package com.veminal.pdf.actions.file;

import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Open".
 *
 * @author Veminal
 * @version 1.0
 */
public final class OpenFileAction implements IEvent {
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
                return "Open";
            }
        };
    }
}
