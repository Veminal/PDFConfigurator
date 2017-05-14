package com.veminal.pdf.actions.toolbar.file;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotation.NotUsed;
import com.veminal.pdf.settings.read.ReadSettings;
import com.veminal.pdf.ui.frame.CreateProjectDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;

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
     * @param menuItemsName of ReadSettings
     * @return Action
     */
    @Override
    @NotUsed
    public Action initializing(final ReadSettings menuItemsName) {
        return null;
    }

    /**
     * Action initializing.
     *
     * @param objName of ReadSettings
     * @param path    of String
     * @return Action
     */
    @Override
    public Action initializing(final ReadSettings objName, final String path) {
        return new Action((String) objName.parse("new"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                CreateProjectDialog create =
                        new CreateProjectDialog(new Shell());
                create.open();
            }
        };
    }
}
