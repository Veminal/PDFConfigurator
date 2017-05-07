package com.veminal.pdf.actions.edit;

import org.eclipse.jface.action.Action;
import com.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Undo select".
 *
 * @author Version
 * @version 1.0
 */
public final class UndoSelectionAction implements IEvent {
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
                return "Undo select";
            }
        };
    }
}
