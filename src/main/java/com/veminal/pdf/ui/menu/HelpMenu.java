package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.help.AboutAction;
import com.veminal.pdf.actions.help.HelpAction;
import com.veminal.pdf.actions.help.LicenseAction;
import com.veminal.pdf.settings.read.ReadDataMenu;
import com.veminal.pdf.settings.read.ReadSettings;
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
        final String path = "dictionaries/dictionary.json";
        ReadSettings<String> readHelpMenu = new ReadDataMenu(path);
        MenuManager manager = new MenuManager(readHelpMenu.parse("menu.help"));
        IEvent about = new AboutAction();
        IEvent help = new HelpAction();
        IEvent license = new LicenseAction();
        ReadSettings<String> readHelp = new ReadDataMenu(path);
        manager.add(help.initializing(readHelp));
        ReadSettings<String> readLicense = new ReadDataMenu(path);
        manager.add(license.initializing(readLicense));
        ReadSettings<String> readAbout = new ReadDataMenu(path);
        manager.add(about.initializing(readAbout));
        return manager;
    }
}
