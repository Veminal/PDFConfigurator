package com.veminal.pdf.actions.help;

import com.veminal.pdf.actions.IEvent;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "License".
 *
 * @author Veminal
 * @version 1.0
 */
public final class LicenseAction implements IEvent {
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
                return "License";
            }
        };
    }
}
