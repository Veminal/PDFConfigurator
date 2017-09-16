package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Settings dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SettingsDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig config;
    /**
     * Path to file.
     */
    private final String pathToFile;

    /**
     * Constructor of class.
     *
     * @param shell the Shell.
     * @param path  the String
     * @param read  the ReadConfig
     */
    @Inject
    public SettingsDialog(final Shell shell, final String path,
                          @StringReader final ReadConfig read) {
        super(shell);
        this.config = read;
        this.pathToFile = path;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        config.readPath(pathToFile);
        newShell.setText((String) config.parse(
                "title.settings.dialog"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 400;
        final int w = 450;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int column = 1;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        return area;
    }
}
