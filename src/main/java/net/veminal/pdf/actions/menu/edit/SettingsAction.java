package net.veminal.pdf.actions.menu.edit;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.events.show.SettingsDialogShow;
import net.veminal.pdf.core.events.show.ShowDialog;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Settings".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SettingsAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("settings")) {
            @Override
            public void run() {
                super.run();
                ShowDialog settingsDialog = new SettingsDialogShow();
                settingsDialog.create();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
