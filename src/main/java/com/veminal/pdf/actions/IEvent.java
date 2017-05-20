package com.veminal.pdf.actions;

import com.veminal.pdf.configuration.read.ReadConfig;
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
     * @param menuItemsName of ReadConfig
     * @return Action
     */
    Action initializing(ReadConfig menuItemsName);

    /**
     * Action initializing.
     *
     * @param objName of ReadConfig
     * @param path of String
     * @return Action
     */
    Action initializing(ReadConfig objName, String path);
}
