package net.veminal.pdf.ui;

import com.google.inject.Inject;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.write.WriteConfig;
import net.veminal.pdf.core.annotations.*;
import net.veminal.pdf.ui.menu.EditMenu;
import net.veminal.pdf.ui.menu.FileMenu;
import net.veminal.pdf.ui.menu.FormatMenu;
import net.veminal.pdf.ui.menu.HelpMenu;
import net.veminal.pdf.ui.menu.IMenu;
import net.veminal.pdf.ui.menu.TableContextMenu;
import net.veminal.pdf.ui.tab.AbstractTab;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.toolbar.ITool;
import net.veminal.pdf.ui.toolbar.ToolbarBuild;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
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
     * Read Size.
     */
    private final ReadConfig readSize;
    /**
     * Path to file.
     */
    private final String path;
    /**
     * Path to image files.
     */
    private final String pathImage;
    /**
     * Size file.
     */
    private final String sizeFile;
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
     * Table context menu.
     */
    private final IEventList tableMenu;
    /**
     * File Browser.
     */
    private AbstractTable fileList;
    /**
     * Tabs.
     */
    private AbstractTab textTab;
    /**
     * Write config.
     */
    private final WriteConfig writeConfig;

    /**
     * Constructor of class.
     *
     * @param read         the ReadConfig
     * @param readImage    the ReadConfig
     * @param sizeRead     the ReadConfig
     * @param pathToFile   the String
     * @param pathToImage  the String
     * @param size         the String
     * @param fMenu        the IEventList
     * @param eMenu        the IEventList
     * @param ftMenu       the IEventList
     * @param hMenu        the IEventList
     * @param tool         the IEventList
     * @param tableContext the EventList
     * @param browser      the AbstractTable
     * @param tab          the AbstractTab
     * @param write        the WriteConfig
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
                 @Toolbar final IEventList tool,
                 @FileTable final AbstractTable browser, final AbstractTab tab,
                 @IntReader final ReadConfig sizeRead, final String size,
                 final WriteConfig write, @TableContext final IEventList tableContext) {
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
        this.fileList = browser;
        this.textTab = tab;
        this.readSize = sizeRead;
        this.sizeFile = size;
        this.writeConfig = write;
        this.tableMenu = tableContext;
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
        readSize.readPath(sizeFile);
        final int height = (int) readSize.parse("window.height");
        readSize.readPath(sizeFile);
        final int width = (int) readSize.parse("window.width");
        final int column = 3;
        Composite content = new Composite(shell, SWT.NONE);
        GridLayout gridLayout = new GridLayout(column, false);
        SashForm splitter = new SashForm(content, SWT.HORIZONTAL);
        splitter.setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
        content.setLayout(gridLayout);
        IMenu tablePopup = new TableContextMenu(readConfig, tableMenu, path);
        fileList.createContents(splitter);
        fileList.addContextMenu(tablePopup.initial());
        textTab.createContents(splitter);
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

    @Override
    @SuppressWarnings("SuspiciousNameCombination")
    protected boolean canHandleShellCloseEvent() {
        final int height = Display.getCurrent().getActiveShell().getSize().x;
        final int width = Display.getCurrent().getActiveShell().getSize().y;
        writeConfig.readToPath(sizeFile);
        writeConfig.writeData(height, width, "window.height",
                "window.width");
        return super.canHandleShellCloseEvent();
    }
}
