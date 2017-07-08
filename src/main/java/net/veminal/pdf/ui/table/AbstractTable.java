package net.veminal.pdf.ui.table;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Abstract class for file browser.
 *
 * @author Veminal
 * @version 1.0
 */
public abstract class AbstractTable {
    /**
     * Table file viewer.
     */
    private Table fileTable;
    /**
     * Item of table.
     */
    private TableItem item;

    /**
     * Tree configuration.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        fileTable = new Table(parent, SWT.CHECK | SWT.BORDER
                | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
        fileTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
    }

    /**
     * Create context menu.
     *
     * @param contextMenu the MenuManager
     */
    public void addContextMenu(final MenuManager contextMenu) {
        Menu menu = contextMenu.createContextMenu(fileTable);
        fileTable.setMenu(menu);
    }

    /**
     * Table items.
     *
     * @param target the T
     */
    public void items(final String target) {
        List filesList = outFilesList(target);
        fileTable.getDisplay().asyncExec(() -> {
            for (Object o : filesList) {
                item = new TableItem(fileTable, SWT.NONE);
                item.setText((String) o);
            }
            MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
                    "Completed",
                    "Operation completed");
        });
    }

    /**
     * Output file list.
     *
     * @param target the String
     * @return list files
     */
    protected abstract List outFilesList(String target);

    /**
     * Set enabled.
     *
     * @param variant the boolean
     */
    public void enabled(final boolean variant) {
        fileTable.setEnabled(variant);
    }
}
