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
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    Action initializing(ReadSettings menuItemsName);

    /**
     * Action initializing.
     *
     * @param objName of ReadSettings
     * @param path of String
     * @return Action
     */
    Action initializing(ReadSettings objName, String path);
}
