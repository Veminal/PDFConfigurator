package com.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.StringReader;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Implementation of the dialog menu for creating a project.
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreatePDFProjectDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig configRead;

    /**
     * Creates a dialog with the given parent.
     *
     * @param parentShell object that returns the current parent shell
     * @param readFile    the ReadConfig
     */
    @Inject
    public CreatePDFProjectDialog(final Shell parentShell,
                                  @StringReader final ReadConfig readFile) {
        super(parentShell);
        this.configRead = readFile;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        final String path = "dictionary.json";
        configRead.readPath(path);
        newShell.setText((String) configRead.parse(
                "create.project.dialog"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 450;
        final int w = 300;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int columns = 1;
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        GridLayout layout = new GridLayout(columns, false);
        container.setLayout(layout);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createProjectName(container);
        createProjectPath(container);
        return area;
    }

    /**
     * Creating a Name Entry Field.
     *
     * @param composite the Composite
     */
    private void createProjectName(final Composite composite) {
        Label labelName = new Label(composite, SWT.NONE);
        final String path = "dictionary.json";
        configRead.readPath(path);
        labelName.setText((String) configRead.parse(
                "project.label.name"));
        GridData dataProjectName = new GridData();
        dataProjectName.grabExcessHorizontalSpace = true;
        dataProjectName.horizontalAlignment = GridData.FILL;
        Text textProjectName = new Text(composite, SWT.BORDER);
        textProjectName.setLayoutData(dataProjectName);
    }

    /**
     * Create a path selection field for the created project.
     *
     * @param composite the Composite
     */
    private void createProjectPath(final Composite composite) {
        Label labelPath = new Label(composite, SWT.NONE);
        final String path = "dictionary.json";
        configRead.readPath(path);
        labelPath.setText((String) configRead.parse(
                "project.label.path"));
        GridData dataProjectPath = new GridData();
        dataProjectPath.grabExcessHorizontalSpace = true;
        dataProjectPath.horizontalAlignment = GridData.FILL;
        Text textProjectPath = new Text(composite, SWT.BORDER);
        textProjectPath.setLayoutData(dataProjectPath);
        Button openPathButton = new Button(composite, SWT.OPEN);
        openPathButton.setLayoutData(new GridData(
                GridData.HORIZONTAL_ALIGN_END));
        Image icon = new Image(Display.getCurrent(), "images/open.png");
        openPathButton.setImage(icon);
        configRead.readPath(path);
        openPathButton.setText((String) configRead.parse(
                "project.create.button"));
        openPathButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent selectionEvent) {
                super.widgetSelected(selectionEvent);
            }
        });
    }
}
