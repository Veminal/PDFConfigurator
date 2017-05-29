package net.veminal.pdf.actions.menu.edit;

import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import net.veminal.pdf.actions.IEvent;

/**
 * Action for menu item "Font".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FontAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("font")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
