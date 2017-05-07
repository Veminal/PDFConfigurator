package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.help.AboutAction;
import com.veminal.pdf.actions.help.HelpAction;
import com.veminal.pdf.actions.help.LicenseAction;
import org.eclipse.jface.action.MenuManager;

/**
 * Create menu item "Help".
 *
 * @author Veminal
 * @version 1.0
 */
public final class HelpMenu implements IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        MenuManager manager = new MenuManager("Help");
        IEvent about = new AboutAction();
        IEvent help = new HelpAction();
        IEvent license = new LicenseAction();
        manager.add(help.initializing());
        manager.add(license.initializing());
        manager.add(about.initializing());
        return manager;
    }
}
