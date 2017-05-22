package com.veminal.pdf.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
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
     * Text project name.
     */
    private Text textProjectName;
    /**
     * Text project path.
     */
    private Text textProjectPath;

    /**
     * Creates a dialog with the given parent.
     *
     * @param parentShell object that returns the current parent shell
     */
    public CreatePDFProjectDialog(final Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Create PDF Project(test)");
    }

    @Override
    protected Point getInitialSize() {
        final int h = 450;
        final int w = 200;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int columns = 2;
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
        labelName.setText("Test text 1 ");
        GridData dataProjectName = new GridData();
        dataProjectName.grabExcessHorizontalSpace = true;
        dataProjectName.horizontalAlignment = GridData.FILL;
        textProjectName = new Text(composite, SWT.BORDER);
        textProjectName.setLayoutData(dataProjectName);
    }

    /**
     * Create a path selection field for the created project.
     *
     * @param composite the Composite
     */
    private void createProjectPath(final Composite composite) {
        Label labelPath = new Label(composite, SWT.NONE);
        labelPath.setText("Test text 2 ");
        GridData dataProjectPath = new GridData();
        dataProjectPath.grabExcessHorizontalSpace = true;
        dataProjectPath.horizontalAlignment = GridData.FILL;
        textProjectPath = new Text(composite, SWT.BORDER);
        textProjectPath.setLayoutData(dataProjectPath);
        Button openPathButton = new Button(composite, SWT.PUSH);
        Image icon = new Image(Display.getCurrent(), "images/open.png");
        openPathButton.setImage(icon);
    }
}
