package com.veminal.pdf.actions.toolbar.edit;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Copy".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CopyAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("copy"),
                ImageDescriptor.createFromFile(null, path)) {
        };
    }
}
