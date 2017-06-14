package net.veminal.pdf.actions.toolbar.build;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.events.show.BuildDialogShow;
import net.veminal.pdf.core.events.show.ShowDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Build".
 *
 * @author Veminal
 * @version 1.0
 */
public final class BuildAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("build.fragments"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                ShowDialog showDialog = new BuildDialogShow();
                showDialog.create();
            }
        };
    }
}
