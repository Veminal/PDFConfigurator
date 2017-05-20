package com.veminal.pdf.actions.toolbar.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.ui.dialogs.CreatePDFProjectDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

/**
 * Action for button "New".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreateAction implements IEvent {
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
        return new Action((String) objName.parse("new"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                CreatePDFProjectDialog dialog =
                        new CreatePDFProjectDialog(Display.getCurrent()
                                .getActiveShell());
                dialog.open();
            }
        };
    }
}
