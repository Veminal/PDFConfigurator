package net.veminal.pdf.actions.menu.help;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.events.show.AboutDialogShow;
import net.veminal.pdf.core.events.show.ShowDialog;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "About".
 *
 * @author Veminal
 * @version 1.0
 */
public final class AboutAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("about")) {
            @Override
            public void run() {
                super.run();
                ShowDialog showDialog = new AboutDialogShow();
                showDialog.create();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
