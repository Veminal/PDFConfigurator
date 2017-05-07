package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.format.AssemblyPDFAction;
import com.veminal.pdf.actions.format.BuildFragmentAction;
import com.veminal.pdf.actions.format.ExtractNumberAction;
import com.veminal.pdf.actions.format.InjectFragmentAction;
import com.veminal.pdf.actions.format.SearchAction;
import com.veminal.pdf.actions.format.SelectFragmentAction;
import com.veminal.pdf.actions.format.SplitPageAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

/**
 * Create menu item "Format".
 *
 * @author Veminal
 * @version 1.0
 */
public final class FormatMenu implements IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    @Override
    public MenuManager initial() {
        MenuManager manager = new MenuManager("Format");
        IEvent selectFragmentAction = new SelectFragmentAction();
        IEvent splitPage = new SplitPageAction();
        IEvent extractNumber = new ExtractNumberAction();
        IEvent search = new SearchAction();
        IEvent buildFragment = new BuildFragmentAction();
        IEvent injectFragment = new InjectFragmentAction();
        IEvent assembly = new AssemblyPDFAction();
        manager.add(selectFragmentAction.initializing());
        manager.add(splitPage.initializing());
        manager.add(extractNumber.initializing());
        manager.add(new Separator());
        manager.add(buildFragment.initializing());
        manager.add(injectFragment.initializing());
        manager.add(assembly.initializing());
        manager.add(new Separator());
        manager.add(search.initializing());
        return manager;
    }
}
