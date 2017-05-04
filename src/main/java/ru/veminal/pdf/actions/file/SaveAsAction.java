package ru.veminal.pdf.actions.file;

import org.eclipse.jface.action.Action;
import ru.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Save As...".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SaveAsAction implements IEvent {
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
                return "Save As...";
            }
        };
    }
}
