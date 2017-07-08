package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.StringReader;
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
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param read        the ReadConfig
     * @param pathToFile  the String
     */
    @Inject
    public ExtractByPageNumberDialog(final Shell parentShell,
                                     @StringReader final ReadConfig read,
                                     final String pathToFile) {
        super(parentShell);
        this.config = read;
        this.path = pathToFile;
    }
}
