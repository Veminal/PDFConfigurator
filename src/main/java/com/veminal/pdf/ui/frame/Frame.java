package com.veminal.pdf.ui.frame;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.FileActionsList;
import com.veminal.pdf.actions.FormatActionsList;
import com.veminal.pdf.actions.HelpActionsList;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.actions.ToolbarActionsList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.configuration.read.ReadDataFields;
import com.veminal.pdf.configuration.read.ReadDataList;
import com.veminal.pdf.core.modules.ActionsListModule;
import com.veminal.pdf.core.modules.ConfigurationModule;
import com.veminal.pdf.ui.menu.EditMenu;
import com.veminal.pdf.ui.menu.FileMenu;
import com.veminal.pdf.ui.menu.FormatMenu;
import com.veminal.pdf.ui.menu.HelpMenu;
import com.veminal.pdf.ui.menu.IMenu;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.List;

/**
 * Template for the user interface.
 *
 * @author Veminal
 * @version 1.0
 */
public final class Frame extends ApplicationWindow {
    /**
     * Constructor of class.
     */
    public Frame() {
        super(null);
        addMenuBar();
        addToolBar(SWT.FLAT | SWT.WRAP);
    }


    /**
     * Set the position of the window.
     *
     * @param shell of Shell
     */
    private void shellLocationFrame(final Shell shell) {
        Monitor monitor = Display.getCurrent().getPrimaryMonitor();
        Rectangle boundsM = monitor.getBounds();
        Rectangle boundsS = shell.getBounds();
        final int inHalf = 2;
        final int x = boundsM.x + (boundsM.width - boundsS.width) / inHalf;
        final int y = boundsM.y + (boundsM.height - boundsS.height) / inHalf;
        shell.setLocation(x, y);
    }

    /**
     * Frame initializing.
     */
    public void run() {
        setBlockOnOpen(true);
        open();
        Display.getCurrent().dispose();
    }

    /**
     * Configure shell.
     *
     * @param shell of Shell
     */
    @Override
    protected void configureShell(final Shell shell) {
        super.configureShell(shell);
        final int height = 800;
        final int width = 600;
        final int column = 3;
        Composite content = new Composite(shell, SWT.NONE);
        GridLayout gridLayout = new GridLayout(column, false);
        SashForm splitter = new SashForm(content, SWT.HORIZONTAL);
        splitter.setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
        content.setLayout(gridLayout);
        TreeViewer pdfList = new TreeViewer(splitter, SWT.LEFT | SWT.BORDER);
        pdfList.getTree().setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
        CTabFolder textTab = new CTabFolder(splitter, SWT.BORDER);
        CTabItem item = new CTabItem(textTab, SWT.CLOSE | SWT.COLOR_RED);
        textTab.setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
        Text pdfText = new Text(textTab, SWT.MULTI | SWT.H_SCROLL
                | SWT.V_SCROLL | SWT.BORDER);
        pdfText.setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
        item.setText("Tab");
        item.setControl(pdfText);
        final int treeWeight = 1;
        final int textWeight = 4;
        Image icon = new Image(Display.getCurrent(), "icon.ico");
        splitter.setWeights(new int[]{treeWeight, textWeight});
        shell.setText("PDF Adjuster");
        shell.setImage(icon);
        shell.setSize(new Point(height, width));
        shellLocationFrame(shell);
    }

    /**
     * Create menu manager.
     *
     * @return Menu
     */
    @Override
    protected MenuManager createMenuManager() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule(),
                new ActionsListModule());
        ReadConfig readFileMenu =
                injectMenu.getInstance(ReadDataFields.class);
        IEventList fileMenu =
                injectMenu.getInstance(FileActionsList.class);
        IEventList editMenu =
                injectMenu.getInstance(EditActionsList.class);
        IEventList formatMenu =
                injectMenu.getInstance(FormatActionsList.class);
        IEventList helpMenu =
                injectMenu.getInstance(HelpActionsList.class);
        IMenu file = new FileMenu(readFileMenu, fileMenu);
        IMenu edit = new EditMenu(readFileMenu, editMenu);
        IMenu format = new FormatMenu(readFileMenu, formatMenu);
        IMenu help = new HelpMenu(readFileMenu, helpMenu);
        MenuManager menu = new MenuManager();
        menu.add(file.initial());
        menu.add(edit.initial());
        menu.add(format.initial());
        menu.add(help.initial());
        return menu;
    }

    /**
     * Returns a new tool bar manager for the window.
     * Subclasses may override this method to customize the tool bar manager.
     *
     * @param style swt style bits used to create the Toolbar
     * @return a tool bar manager
     */
    @Override
    protected ToolBarManager createToolBarManager(final int style) {
        final String path = "dictionary.json";
        final String pathImages = "images.json";
        ToolBarManager manager = new ToolBarManager();
        ReadConfig<List<String>> imagePath = new ReadDataList();
        ReadConfig<String> reader = new ReadDataFields();
        imagePath.readPath(pathImages);
        List<String> images = imagePath.parse("path");
        IEventList toolbarActionsList = new ToolbarActionsList();
        List<IEvent> toolList = toolbarActionsList.getActionList();
        int i = 0;
        for (IEvent action : toolList) {
            reader.readPath(path);
            manager.add(action.initializing(reader, images.get(i)));
            i++;
        }
        toolList.clear();
        images.clear();
        return manager;
    }
}
