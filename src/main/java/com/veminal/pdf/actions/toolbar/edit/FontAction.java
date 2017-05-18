package com.veminal.pdf.actions.toolbar.edit;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.settings.read.ReadConfig;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Font".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FontAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadConfig
     * @return Action
     */
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    /**
     * Action initializing.
     *
     * @param objName of ReadConfig
     * @param path    of String
     * @return Action
     */
    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("font"),
                ImageDescriptor.createFromFile(null, path)) {
        };
    }
}
