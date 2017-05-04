package ru.veminal.pdf.actions.edit;

import org.eclipse.jface.action.Action;
import ru.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Delete".
 *
 * @author Veminal
 * @author 1.0
 */
public final class DeleteAction implements IEvent {
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
                return "Delete";
            }
        };
    }
}
