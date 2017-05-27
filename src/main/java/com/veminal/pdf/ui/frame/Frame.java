package com.veminal.pdf.ui.frame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.FileActionsList;
import com.veminal.pdf.actions.FormatActionsList;
import com.veminal.pdf.actions.HelpActionsList;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.actions.ToolbarActionsList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.configuration.read.ReadDataFields;
import com.veminal.pdf.configuration.read.ReadDataList;
import com.veminal.pdf.core.annotations.StringReader;
import com.veminal.pdf.core.modules.ActionsListModule;
import com.veminal.pdf.core.modules.ConfigurationModule;
import com.veminal.pdf.core.modules.ToolbarModule;
import com.veminal.pdf.ui.menu.EditMenu;
import com.veminal.pdf.ui.menu.FileMenu;
import com.veminal.pdf.ui.menu.FormatMenu;
import com.veminal.pdf.ui.menu.HelpMenu;
import com.veminal.pdf.ui.menu.IMenu;
import com.veminal.pdf.ui.toolbar.ITool;
import com.veminal.pdf.ui.toolbar.ToolbarBuild;
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

/**
 * Template for the user interface.
 *
 * @author Veminal
 * @version 1.0
 */
public final class Frame extends ApplicationWindow {
    /**
     * Injector.
     */
    private Injector injectObject;
    /**
     * Read config.
     */
    private final ReadConfig readConfig;
    /**
     * Path to file.
     */
    private final String path;
    /**
     * Path to image files.
     */
    private final String pathImage;

    /**
     * Constructor of class.
     *
     * @param read        the ReadConfig
     * @param pathToFile  the String
     * @param pathToImage the String
     */
    @Inject
    public Frame(@StringReader final ReadConfig read,
                 final String pathToFile, final String pathToImage) {
        super(null);
        injectObject = Guice.createInjector(
                new ConfigurationModule(),
                new ActionsListModule(),
                new ToolbarModule());
        this.readConfig = read;
        this.path = pathToFile;
        this.pathImage = pathToImage;
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
        TreeViewer pdfList = new TreeViewer(splitter, SWT.LEFT | SWT.BORDER
                | SWT.V_SCROLL);
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
        readConfig.readPath(path);
        shell.setText((String) readConfig.parse("frame.title"));
        shell.setImage(icon);
        shell.setSize(new Point(height, width));
        shellLocationFrame(shell);
    }

    @Override
    protected MenuManager createMenuManager() {
        ReadConfig readFileMenu = injectObject.getInstance(
                ReadDataFields.class);
        IEventList fileMenu = injectObject.getInstance(
                FileActionsList.class);
        IEventList editMenu = injectObject.getInstance(
                EditActionsList.class);
        IEventList formatMenu = injectObject.getInstance(
                FormatActionsList.class);
        IEventList helpMenu = injectObject.getInstance(
                HelpActionsList.class);
        IMenu file = new FileMenu(readFileMenu, fileMenu, path);
        IMenu edit = new EditMenu(readFileMenu, editMenu, path);
        IMenu format = new FormatMenu(readFileMenu, formatMenu, path);
        IMenu help = new HelpMenu(readFileMenu, helpMenu, path);
        MenuManager menu = new MenuManager();
        menu.add(file.initial());
        menu.add(edit.initial());
        menu.add(format.initial());
        menu.add(help.initial());
        return menu;
    }

    @Override
    protected ToolBarManager createToolBarManager(final int style) {
        ReadConfig readText = injectObject.getInstance(ReadDataFields.class);
        ReadConfig readImage = injectObject.getInstance(ReadDataList.class);
        IEventList toolbarAction = injectObject.getInstance(
                ToolbarActionsList.class);
        ITool tool = new ToolbarBuild(readText, readImage, toolbarAction, path, pathImage);
        return tool.initial();
    }
}
