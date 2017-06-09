package net.veminal.pdf.actions.menu.file;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Print".
 *
 * @author Veminal
 * @version 1.0
 */
public final class PrintFileAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("print.pdf")) {
        };
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
