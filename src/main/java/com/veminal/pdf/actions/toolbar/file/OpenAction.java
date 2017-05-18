package com.veminal.pdf.actions.toolbar.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.settings.read.ReadConfig;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Open".
 *
 * @author Veminal
 * @version 1.0
 */
public final class OpenAction implements IEvent {
    /**
     * Action initializing.
     *
     * @param menuItemsName of ReadConfig
     * @return Action
     */
    @Override
    @NotUsed
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
        return new Action((String) objName.parse("open"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
            }
        };
    }
}
