package com.veminal.pdf.actions.format;

import com.veminal.pdf.actions.IEvent;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Inject fragments".
 */
public final class InjectFragmentAction implements IEvent {
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
                return "Inject fragments";
            }
        };
    }
}
