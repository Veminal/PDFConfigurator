package net.veminal.pdf.actions.menu.edit;

import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.actions.IEvent;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Paste".
 *
 * @author Veminal
 * @version 1.0
 */
public final class PasteAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("paste")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
