package net.veminal.pdf.actions.menu.help;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Help".
 *
 * @author Veminal
 * @version 1.0
 */
public final class HelpAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("help")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
