package net.veminal.pdf.ui.table;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
     * Setup table.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        fileTable = configTable(parent);
    }

    /**
     * Configuration table.
     *
     * @param parent the Composite
     * @return Table
     */
    protected abstract Table configTable(Composite parent);

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

    /**
     * Set check items.
     */
    public void setItemsChecked() {
        TableItem[] items = fileTable.getItems();
        for (TableItem i : items) {
            i.setChecked(true);
        }
    }

    /**
     * Disable check items.
     */
    public void disableItemCheck() {
        TableItem[] items = fileTable.getItems();
        for (TableItem i : items) {
            i.setChecked(false);
        }
    }

    /**
     * Get items text list.
     *
     * @return documents list
     */
    public List<String> getItemsText() {
        TableItem[] items = fileTable.getItems();
        List<String> docList = new ArrayList<>();
        for (TableItem i : items) {
            if (i.getChecked()) {
                docList.add(i.getText());
            }
        }
        return docList;
    }

    /**
     * Update table.
     */
    public void updateTable() {
        TableItem[] items = fileTable.getItems();
        for (TableItem i : items) {
            i.dispose();
        }
    }
}
