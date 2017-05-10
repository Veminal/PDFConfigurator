package com.veminal.pdf.ui.frame;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.toolbar.build.BuildAction;
import com.veminal.pdf.actions.toolbar.build.InjectAction;
import com.veminal.pdf.actions.toolbar.edit.CopyAction;
import com.veminal.pdf.actions.toolbar.edit.CutAction;
import com.veminal.pdf.actions.toolbar.edit.FontAction;
import com.veminal.pdf.actions.toolbar.edit.PasteAction;
import com.veminal.pdf.actions.toolbar.file.CreateAction;
import com.veminal.pdf.actions.toolbar.file.DeleteAction;
import com.veminal.pdf.actions.toolbar.file.OpenAction;
import com.veminal.pdf.actions.toolbar.file.SaveAction;
import com.veminal.pdf.actions.toolbar.settings.SettingsAction;
import com.veminal.pdf.actions.toolbar.split.CutNumberAction;
import com.veminal.pdf.actions.toolbar.split.FragmentAction;
import com.veminal.pdf.actions.toolbar.split.SplitPageAction;
import com.veminal.pdf.settings.read.ReadDataFile;
import com.veminal.pdf.settings.read.ReadSettings;
import com.veminal.pdf.ui.menu.EditMenu;
import com.veminal.pdf.ui.menu.FileMenu;
import com.veminal.pdf.ui.menu.FormatMenu;
import com.veminal.pdf.ui.menu.HelpMenu;
import com.veminal.pdf.ui.menu.IMenu;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
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
     * Constructor of class.
     *
     * @param parentShell of Shell
     */
    public Frame(final Shell parentShell) {
        super(null);
        parentShell.setLayout(new FillLayout());
        addMenuBar();
        addToolBar(SWT.FLAT | SWT.WRAP);
    }

    /**
     * Set the position of the window.
     *
     * @param shell of Shell
     */
    private void shellLocationCenter(final Shell shell) {
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
        final int height = 1200;
        final int width = 700;
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
        final int textWeight = 5;
        splitter.setWeights(new int[]{treeWeight, textWeight});
        shell.setText("PDF Adjuster");
        shell.setMinimumSize(new Point(height, width));
        shellLocationCenter(shell);
        shell.pack();
    }

    /**
     * Create menu manager.
     *
     * @return Menu
     */
    @Override
    protected MenuManager createMenuManager() {
        IMenu file = new FileMenu();
        IMenu edit = new EditMenu();
        IMenu format = new FormatMenu();
        IMenu help = new HelpMenu();
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
        ToolBarManager manager = new ToolBarManager();
        final String path = "dictionaries/dictionary.json";
        final String createImagePath = "images/new.png";
        final String openImagePath = "images/open.png";
        final String saveImagePath = "images/save.png";
        final String deleteImagePath = "images/del.png";
        final String cutImagePath = "images/cut.png";
        final String copyImagePath = "images/copy.png";
        final String pasteImagePath = "images/paste.png";
        final String fontImagePath = "images/font.png";
        final String cutNumberImagePath = "images/cut_number.png";
        final String fragmentImagePath = "images/fragment_select.png";
        final String splitImagePath = "images/split_page.png";
        final String buildImagePath = "images/build.png";
        final String injectImagePath = "images/inject.png";
        final String settingsImagePath = "images/settings.png";
        ReadSettings<String> createButtonName = new ReadDataFile(path);
        ReadSettings<String> openButtonName = new ReadDataFile(path);
        ReadSettings<String> saveButtonName = new ReadDataFile(path);
        ReadSettings<String> delButtonName = new ReadDataFile(path);
        ReadSettings<String> cutButtonName = new ReadDataFile(path);
        ReadSettings<String> copyButtonName = new ReadDataFile(path);
        ReadSettings<String> pasteButtonName = new ReadDataFile(path);
        ReadSettings<String> fontButtonName = new ReadDataFile(path);
        ReadSettings<String> cutNumberButtonName = new ReadDataFile(path);
        ReadSettings<String> fragmentButtonName = new ReadDataFile(path);
        ReadSettings<String> splitButtonName = new ReadDataFile(path);
        ReadSettings<String> buildButtonName = new ReadDataFile(path);
        ReadSettings<String> injectButtonName = new ReadDataFile(path);
        ReadSettings<String> settingsButtonName = new ReadDataFile(path);
        IEvent create = new CreateAction();
        IEvent open = new OpenAction();
        IEvent save = new SaveAction();
        IEvent delete = new DeleteAction();
        IEvent cut = new CutAction();
        IEvent copy = new CopyAction();
        IEvent paste = new PasteAction();
        IEvent font = new FontAction();
        IEvent cutNumber = new CutNumberAction();
        IEvent fragment = new FragmentAction();
        IEvent split = new SplitPageAction();
        IEvent build = new BuildAction();
        IEvent inject = new InjectAction();
        IEvent settings = new SettingsAction();
        manager.add(create.initializing(createButtonName, createImagePath));
        manager.add(open.initializing(openButtonName, openImagePath));
        manager.add(save.initializing(saveButtonName, saveImagePath));
        manager.add(delete.initializing(delButtonName, deleteImagePath));
        manager.add(new Separator());
        manager.add(cut.initializing(cutButtonName, cutImagePath));
        manager.add(copy.initializing(copyButtonName, copyImagePath));
        manager.add(paste.initializing(pasteButtonName, pasteImagePath));
        manager.add(font.initializing(fontButtonName, fontImagePath));
        manager.add(new Separator());
        manager.add(cutNumber.initializing(
                cutNumberButtonName, cutNumberImagePath));
        manager.add(fragment.initializing(
                fragmentButtonName, fragmentImagePath));
        manager.add(split.initializing(splitButtonName, splitImagePath));
        manager.add(new Separator());
        manager.add(build.initializing(buildButtonName, buildImagePath));
        manager.add(inject.initializing(injectButtonName, injectImagePath));
        manager.add(new Separator());
        manager.add(settings.initializing(
                settingsButtonName, settingsImagePath));
        return manager;
    }
}
