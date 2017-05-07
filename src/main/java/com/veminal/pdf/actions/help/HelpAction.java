package com.veminal.pdf.actions.help;

import com.veminal.pdf.actions.IEvent;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Help".
 *
 * @author Veminal
 * @version 1.0
 */
public final class HelpAction implements IEvent {
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
                return "Help";
            }
        };
    }
}
