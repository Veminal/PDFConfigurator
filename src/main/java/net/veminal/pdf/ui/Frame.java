package net.veminal.pdf.ui;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.EditList;
import net.veminal.pdf.core.annotations.FileList;
import net.veminal.pdf.core.annotations.FormatList;
import net.veminal.pdf.core.annotations.HelpList;
import net.veminal.pdf.core.annotations.ListReader;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.core.annotations.Toolbar;
import net.veminal.pdf.ui.menu.EditMenu;
import net.veminal.pdf.ui.menu.FileMenu;
import net.veminal.pdf.ui.menu.FormatMenu;
import net.veminal.pdf.ui.menu.HelpMenu;
import net.veminal.pdf.ui.menu.IMenu;
import net.veminal.pdf.ui.toolbar.ITool;
import net.veminal.pdf.ui.toolbar.ToolbarBuild;
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
     * Read config.
     */
    private final ReadConfig readConfig;
    /**
     * Read config image.
     */
    private final ReadConfig readConfigImage;
    /**
     * Path to file.
     */
    private final String path;
    /**
     * Path to image files.
     */
    private final String pathImage;
    /**
     * File menu.
     */
    private final IEventList fileMenu;
    /**
     * Edit menu.
     */
    private final IEventList editMenu;
    /**
     * Format menu.
     */
    private final IEventList formatMenu;
    /**
     * Help menu.
     */
    private final IEventList helpMenu;
    /**
     * Toolbar.
     */
    private final IEventList toolbarAction;

    /**
     * Constructor of class.
     *
     * @param read        the ReadConfig
     * @param readImage   the ReadConfig
     * @param pathToFile  the String
     * @param pathToImage the String
     * @param fMenu       the IEventList
     * @param eMenu       the IEventList
     * @param ftMenu      the IEventList
     * @param hMenu       the IEventList
     * @param tool        the IEventList
     */
    @Inject
    @SuppressWarnings("ALL")
    public Frame(@StringReader final ReadConfig read,
                 @ListReader final ReadConfig readImage,
                 final String pathToFile, final String pathToImage,
                 @FileList final IEventList fMenu,
                 @EditList final IEventList eMenu,
                 @FormatList final IEventList ftMenu,
                 @HelpList final IEventList hMenu,
                 @Toolbar final IEventList tool) {
        super(null);
        this.readConfig = read;
        this.path = pathToFile;
        this.pathImage = pathToImage;
        this.readConfigImage = readImage;
        this.fileMenu = fMenu;
        this.editMenu = eMenu;
        this.formatMenu = ftMenu;
        this.helpMenu = hMenu;
        this.toolbarAction = tool;
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
        IMenu file = new FileMenu(readConfig, fileMenu, path);
        IMenu edit = new EditMenu(readConfig, editMenu, path);
        IMenu format = new FormatMenu(readConfig, formatMenu, path);
        IMenu help = new HelpMenu(readConfig, helpMenu, path);
        MenuManager menu = new MenuManager();
        menu.add(file.initial());
        menu.add(edit.initial());
        menu.add(format.initial());
        menu.add(help.initial());
        return menu;
    }

    @Override
    protected ToolBarManager createToolBarManager(final int style) {
        ITool tool = new ToolbarBuild(readConfig, readConfigImage,
                toolbarAction, path, pathImage);
        return tool.initial();
    }
}
