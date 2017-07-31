package net.veminal.pdf.ui.table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Split file browser.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitFileTableBrowser extends AbstractTable {
    @Override
    protected Table configTable(final Composite parent) {
        Table fileTable = new Table(parent, SWT.CHECK | SWT.BORDER
                | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
        fileTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
        return fileTable;
    }

    @Override
    protected List outFilesList(final String target) {
        File path = new File(target);
        File[] files = path.listFiles();
        assert files != null;
        List<String> listFiles = new ArrayList<>();
        for (File f : files) {
            listFiles.add(f.getAbsolutePath());
        }
        listFiles.sort(Comparator.comparingInt(String::length));
        return listFiles;
    }
}
