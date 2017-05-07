package com.veminal.pdf.actions.edit;

import com.veminal.pdf.actions.IEvent;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Settings".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SettingAction implements IEvent {
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
                return "Settings";
            }
        };
    }
}
