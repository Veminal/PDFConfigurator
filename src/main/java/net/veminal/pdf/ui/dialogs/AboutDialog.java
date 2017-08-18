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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
     * Path to about file.
     */
    private final String aboutPath;

    /**
     * Instantiate a new title area dialog.
     *
     * @param parentShell the parent SWT shell
     * @param config      the ReadConfig
     * @param pathToFile  the String
     * @param aPath       the String
     */
    @Inject
    public AboutDialog(final Shell parentShell,
                       @StringReader final ReadConfig config,
                       final String pathToFile, final String aPath) {
        super(parentShell);
        this.path = pathToFile;
        this.readConfig = config;
        this.aboutPath = aPath;
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
    protected Control createContents(final Composite parent) {
        final int column = 1;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createLabels(composite);
        return composite;
    }

    /**
     * Create labels.
     *
     * @param parent the Composite
     */
    private void createLabels(final Composite parent) {
        Label iconLabel = new Label(parent, SWT.ICON);
        iconLabel.setImage(Display.getCurrent().getActiveShell().getImage());
        Label projectLabel = new Label(parent, SWT.NONE);
        readConfig.readPath(aboutPath);
        projectLabel.setText((String) readConfig.parse("name_program"));
        Label versionLabel = new Label(parent, SWT.NONE);
        readConfig.readPath(aboutPath);
        versionLabel.setText((String) readConfig.parse("version_program"));
        Label authorLabel = new Label(parent, SWT.NONE);
        readConfig.readPath(aboutPath);
        authorLabel.setText((String) readConfig.parse("author"));
        Label licenseLabel = new Label(parent, SWT.NONE);
        readConfig.readPath(aboutPath);
        licenseLabel.setText((String) readConfig.parse("license"));
    }
}
