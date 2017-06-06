package net.veminal.pdf.ui.table;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

/**
 * Tree file browser.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FileTableBrowser extends AbstractTable {
    /**
     * Table item.
     */
    private TableItem item;

    @Override
    public void items(final Table parent, final int i) {
        item = new TableItem(parent, i);
    }
}
