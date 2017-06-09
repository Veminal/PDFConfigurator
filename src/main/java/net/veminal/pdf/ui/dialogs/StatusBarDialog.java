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
 * The window displaying the status of the partition.
 *
 * @author Veminal
 * @version 1.0
 */
public final class StatusBarDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig readConfig;
    /**
     * Path to file.
     */
    private final String path;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param config      the ReadConfig
     * @param pathToFile  the String
     */
    @Inject
    public StatusBarDialog(final Shell parentShell,
                           @StringReader final ReadConfig config,
                           final String pathToFile) {
        super(parentShell);
        this.readConfig = config;
        this.path = pathToFile;
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, true);
    }

    @Override
    protected Point getInitialSize() {
        final int h = 500;
        final int w = 200;
        return new Point(h, w);
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        readConfig.readPath(path);
        newShell.setText((String) readConfig.parse(
                "split.status.title"));
    }
}
