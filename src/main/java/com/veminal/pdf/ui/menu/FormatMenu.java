package com.veminal.pdf.ui.menu;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.menu.format.AssemblyPDFAction;
import com.veminal.pdf.actions.menu.format.BuildFragmentAction;
import com.veminal.pdf.actions.menu.format.ExtractNumberAction;
import com.veminal.pdf.actions.menu.format.InjectFragmentAction;
import com.veminal.pdf.actions.menu.format.SearchAction;
import com.veminal.pdf.actions.menu.format.SelectFragmentAction;
import com.veminal.pdf.actions.menu.format.SplitPageAction;
import com.veminal.pdf.settings.read.ReadDataFile;
import com.veminal.pdf.settings.read.ReadSettings;
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
        final String path = "dictionaries/dictionary.json";
        ReadSettings<String> readFormatMenu = new ReadDataFile(path);
        MenuManager manager = new MenuManager(readFormatMenu.parse(
                "menu.format"));
        IEvent selectFragmentAction = new SelectFragmentAction();
        IEvent splitPage = new SplitPageAction();
        IEvent extractNumber = new ExtractNumberAction();
        IEvent search = new SearchAction();
        IEvent buildFragment = new BuildFragmentAction();
        IEvent injectFragment = new InjectFragmentAction();
        IEvent assembly = new AssemblyPDFAction();
        ReadSettings<String> readSelect = new ReadDataFile(path);
        manager.add(selectFragmentAction.initializing(readSelect));
        ReadSettings<String> readSplit = new ReadDataFile(path);
        manager.add(splitPage.initializing(readSplit));
        ReadSettings<String> readExtract = new ReadDataFile(path);
        manager.add(extractNumber.initializing(readExtract));
        manager.add(new Separator());
        ReadSettings<String> readBuild = new ReadDataFile(path);
        manager.add(buildFragment.initializing(readBuild));
        ReadSettings<String> readInject = new ReadDataFile(path);
        manager.add(injectFragment.initializing(readInject));
        ReadSettings<String> readAssembly = new ReadDataFile(path);
        manager.add(assembly.initializing(readAssembly));
        manager.add(new Separator());
        ReadSettings<String> readSearch = new ReadDataFile(path);
        manager.add(search.initializing(readSearch));
        return manager;
    }
}
