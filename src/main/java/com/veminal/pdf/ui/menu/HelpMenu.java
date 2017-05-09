package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.menu.help.AboutAction;
import com.veminal.pdf.actions.menu.help.HelpAction;
import com.veminal.pdf.actions.menu.help.LicenseAction;
import com.veminal.pdf.settings.read.ReadDataFile;
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
        ReadSettings<String> readHelpMenu = new ReadDataFile(path);
        MenuManager manager = new MenuManager(readHelpMenu.parse("menu.help"));
        IEvent about = new AboutAction();
        IEvent help = new HelpAction();
        IEvent license = new LicenseAction();
        ReadSettings<String> readHelp = new ReadDataFile(path);
        manager.add(help.initializing(readHelp));
        ReadSettings<String> readLicense = new ReadDataFile(path);
        manager.add(license.initializing(readLicense));
        ReadSettings<String> readAbout = new ReadDataFile(path);
        manager.add(about.initializing(readAbout));
        return manager;
    }
}
