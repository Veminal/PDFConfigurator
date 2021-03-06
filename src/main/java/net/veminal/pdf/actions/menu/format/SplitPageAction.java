package net.veminal.pdf.actions.menu.format;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.events.show.ShowDialog;
import net.veminal.pdf.core.events.show.SplitDialogShow;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Split by Page".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitPageAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("split.page")) {
            @Override
            public void run() {
                super.run();
                ShowDialog show = new SplitDialogShow();
                show.create();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
