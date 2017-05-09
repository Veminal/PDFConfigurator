package com.veminal.pdf.actions;

import com.veminal.pdf.settings.read.ReadSettings;
import org.eclipse.jface.action.Action;

/**
 * Actions configuration interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IEvent {
    /**
     * Action initializing.
     *
     * @param MenuItemsName of ReadSettings
     * @return Action
     */
    Action initializing(ReadSettings menuItemsName);
}
