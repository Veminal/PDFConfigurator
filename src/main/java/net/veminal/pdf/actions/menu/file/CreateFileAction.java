package net.veminal.pdf.actions.menu.file;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "New".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreateFileAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("create")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
