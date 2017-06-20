package net.veminal.pdf.ui.table;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
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
        fileTable.setLinesVisible(true);
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
     * @param target the String
     */
    public void items(final String target) {
        List filesList = outFilesList(target);
        for (Object o : filesList) {
            item = new TableItem(fileTable, SWT.NONE);
            item.setText((String) o);
        }
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

    /**
     * Item click.
     */
    public void itemClick() {
        item.addListener(SWT.NONE, event -> {
        });
    }
}
