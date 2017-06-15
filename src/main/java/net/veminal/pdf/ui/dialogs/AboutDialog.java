package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * Create about window.
 *
 * @author Veminal
 * @version 1.0
 */
public final class AboutDialog extends Dialog {
    /**
     * Path to file.
     */
    private final String path;
    /**
     * Read configuration.
     */
    private final ReadConfig readConfig;

    /**
     * Instantiate a new title area dialog.
     *
     * @param parentShell the parent SWT shell
     * @param config      the ReadConfig
     * @param pathToFile  the String
     */
    @Inject
    public AboutDialog(final Shell parentShell,
                       @StringReader final ReadConfig config,
                       final String pathToFile) {
        super(parentShell);
        this.path = pathToFile;
        this.readConfig = config;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        readConfig.readPath(path);
        newShell.setText((String) readConfig.parse(
                "about.dialog.title"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 350;
        final int w = 450;
        return new Point(h, w);
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
    }
}
