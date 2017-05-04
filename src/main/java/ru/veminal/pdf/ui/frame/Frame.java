package ru.veminal.pdf.ui.frame;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import ru.veminal.pdf.ui.menu.EditMenu;
import ru.veminal.pdf.ui.menu.IMenu;
import ru.veminal.pdf.ui.menu.FileMenu;

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
        super(parentShell);
        addMenuBar();
        addToolBar(SWT.NONE);
        addStatusLine();
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
        MenuManager menu = new MenuManager();
        menu.add(file.initial());
        menu.add(edit.initial());
        return menu;
    }
}
