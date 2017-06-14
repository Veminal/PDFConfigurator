package net.veminal.pdf.actions.toolbar.split;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.events.show.ShowDialog;
import net.veminal.pdf.core.events.show.SplitDialogShow;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Split page".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitPageAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("split.page"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                ShowDialog dialog = new SplitDialogShow();
                dialog.create();
            }
        };
    }
}
