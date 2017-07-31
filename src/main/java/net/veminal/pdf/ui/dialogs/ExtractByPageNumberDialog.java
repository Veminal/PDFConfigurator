package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.PageTable;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.ui.table.AbstractTable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Extract by page number dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExtractByPageNumberDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig config;

    /**
     * Path to file.
     */
    private final String path;
    /**
     * Page table.
     */
    private final AbstractTable pageTable;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param read        the ReadConfig
     * @param pathToFile  the String
     * @param pTable      the AbstractTable
     */
    @Inject
    public ExtractByPageNumberDialog(final Shell parentShell,
                                     @StringReader final ReadConfig read,
                                     final String pathToFile,
                                     @PageTable final AbstractTable pTable) {
        super(parentShell);
        this.config = read;
        this.path = pathToFile;
        this.pageTable = pTable;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        config.readPath(path);
        newShell.setText((String) config.parse(
                "extract.pages.dialog.title"));
    }
}
