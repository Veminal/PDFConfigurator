package com.veminal.pdf.actions.edit;

import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Copy".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CopyAction implements IEvent {
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
                return "Copy";
            }
        };
    }
}
