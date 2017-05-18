package com.veminal.pdf.ui.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;

/**
 * Implementation of the dialog menu for creating a project.
 *
 * @author Veminal
 * @version 1.0
 */
public class CreatePDFProjectDialog extends Dialog {
    /**
     * Creates a dialog with the given parent.
     *
     * @param parentShell object that returns the current parent shell
     */
    public CreatePDFProjectDialog(final Shell parentShell) {
        super(parentShell);
    }

    /**
     * Configures the given shell in preparation for opening this window in it.
     * <p>
     * The default implementation of this framework method sets the shell's
     * image and gives it a grid layout. Subclasses may extend or reimplement.
     * </p>
     *
     * @param newShell the shell
     */
    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Create PDF Project");
    }

    /**
     * Returns the initial size to use for the shell. Overridden
     * to check whether a size has been stored in dialog settings.
     * If a size has been stored, it is returned.
     *
     * @return the initial size of the shell
     */
    @Override
    protected Point getInitialSize() {
        final int h = 500;
        final int w = 200;
        return new Point(h, w);
    }
}
