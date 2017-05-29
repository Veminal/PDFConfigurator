package net.veminal.pdf.actions;

import net.veminal.pdf.actions.menu.help.AboutAction;
import net.veminal.pdf.actions.menu.help.HelpAction;
import net.veminal.pdf.actions.menu.help.LicenseAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the "Help" menu.
 *
 * @author Veminal
 * @version 1.0
 */
public final class HelpActionsList implements IEventList {
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> helpList = new ArrayList<>();
        IEvent about = new AboutAction();
        IEvent help = new HelpAction();
        IEvent license = new LicenseAction();
        helpList.add(about);
        helpList.add(help);
        helpList.add(license);
        return helpList;
    }
}
