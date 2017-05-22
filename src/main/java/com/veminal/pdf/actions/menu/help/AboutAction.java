package com.veminal.pdf.actions.menu.help;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.ui.dialogs.AboutDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;

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
                AboutDialog dialog = new AboutDialog(
                        Display.getCurrent().getActiveShell());
                dialog.open();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
