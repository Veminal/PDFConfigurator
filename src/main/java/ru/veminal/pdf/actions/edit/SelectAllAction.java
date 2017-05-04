package ru.veminal.pdf.actions.edit;

import org.eclipse.jface.action.Action;
import ru.veminal.pdf.actions.IEvent;

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
     * @return Action
     */
    @Override
    public Action initializing() {
        return new Action() {
            @Override
            public String getText() {
                return "Select all";
            }
        };
    }
}
