package net.veminal.pdf.actions.menu.format;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.events.show.BuildDialogShow;
import net.veminal.pdf.core.events.show.ShowDialog;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Assembly PDF".
 *
 * @author Veminal
 * @version 1.0
 */
public final class AssemblyPDFAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("assembly.pdf")) {
            @Override
            public void run() {
                super.run();
                ShowDialog dialog = new BuildDialogShow();
                dialog.create();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
