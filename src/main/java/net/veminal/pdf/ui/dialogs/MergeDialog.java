package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.MergeFileTable;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.ui.table.AbstractTable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Merge dialog window.
 *
 * @author Veminal
 * @version 1.0
 */
public final class MergeDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig config;
    /**
     * Path to file config.
     */
    private final String path;
    /**
     * Path to default file.
     */
    private final String defaultPath;
    /**
     * File list table.
     */
    private final AbstractTable fileTable;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param readConfig  the ReadConfig
     * @param filePath    the String
     * @param defPath     the String
     * @param table       the AbstractTable
     */
    @Inject
    public MergeDialog(final Shell parentShell,
                       @StringReader final ReadConfig readConfig,
                       final String filePath, final String defPath,
                       @MergeFileTable final AbstractTable table) {
        super(parentShell);
        this.config = readConfig;
        this.path = filePath;
        this.defaultPath = defPath;
        this.fileTable = table;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        config.readPath(path);
        newShell.setText((String) config.parse("title.merge.dialog"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 400;
        final int w = 450;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int column = 3;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createTable(composite);
        return area;
    }

    /**
     * Create table.
     *
     * @param parent the Composite
     */
    private void createTable(final Composite parent) {
        fileTable.createContents(parent);
        fileTable.enabled(true);
    }
}
