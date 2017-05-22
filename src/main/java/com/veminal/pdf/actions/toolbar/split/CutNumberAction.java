package com.veminal.pdf.actions.toolbar.split;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Cut number".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CutNumberAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("extract.number"),
                ImageDescriptor.createFromFile(null, path)) {
        };
    }
}
