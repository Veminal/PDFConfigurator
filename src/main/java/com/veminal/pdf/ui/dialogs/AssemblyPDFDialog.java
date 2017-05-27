package com.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * Assembly PDF dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class AssemblyPDFDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig readConfig;
    /**
     * Path to file.
     */
    private final String path;
    /**
     * A radio button with the help of which
     * the choice of the method of assembly is made,
     * when assembly is made in one page.
     */
    private Button onePageButton;
    /**
     * A radio button with the help of which
     * the choice of the assembly method takes place,
     * in which several pages are assembled.
     */
    private Button multiPageButton;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param config      the ReadConfig
     * @param pathToFile  the String
     */
    @Inject
    public AssemblyPDFDialog(final Shell parentShell,
                             @StringReader final ReadConfig config,
                             final String pathToFile) {
        super(parentShell);
        this.readConfig = config;
        this.path = pathToFile;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        readConfig.readPath(path);
        newShell.setText((String) readConfig.parse(
                "assembly.dialog.title"));
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int column = 1;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createOnePageButton(composite);
        createMultiPageButton(composite);
        createDataList(composite);
        return area;
    }

    /**
     * Initializing one page button.
     *
     * @param composite the Composite
     */
    private void createOnePageButton(final Composite composite) {
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        onePageButton = new Button(composite, SWT.RADIO);
        readConfig.readPath(path);
        onePageButton.setText((String) readConfig.parse("one.page"));
        onePageButton.setLayoutData(data);
    }

    /**
     * Initializing multi page button.
     *
     * @param composite the Composite
     */
    private void createMultiPageButton(final Composite composite) {
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        multiPageButton = new Button(composite, SWT.RADIO);
        readConfig.readPath(path);
        multiPageButton.setText((String) readConfig.parse("multi.page"));
        multiPageButton.setLayoutData(data);
    }

    /**
     * Initializing list files.
     *
     * @param composite the Composite
     */
    private void createDataList(final Composite composite) {
        Label titleLabel = new Label(composite, SWT.NONE);
        readConfig.readPath(path);
        titleLabel.setText((String) readConfig.parse("list.files"));
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL_VERTICAL;
        List listFiles = new List(composite, SWT.V_SCROLL);
        listFiles.setLayoutData(new GridData(GridData.FILL, GridData.FILL,
                true, true));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 300;
        final int w = 450;
        return new Point(h, w);
    }
}
