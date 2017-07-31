package net.veminal.pdf.actions.toolbar.split;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.events.show.CutNumberDialogShow;
import net.veminal.pdf.core.events.show.ShowDialog;
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
            @Override
            public void run() {
                ShowDialog dialog = new CutNumberDialogShow();
                dialog.create();
            }
        };
    }
}
