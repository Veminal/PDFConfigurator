package com.veminal.pdf.ui.dialogs;

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
     * Instantiate a new title area dialog.
     *
     * @param parentShell the parent SWT shell
     */
    public AboutDialog(final Shell parentShell) {
        super(parentShell);
    }

    /**
     * Configures the given shell in preparation
     * for opening this window in it.
     *
     * @param newShell the shell
     */
    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Test");
    }

    /**
     * Returns the initial size to use for the shell. Overridden
     * to check whether a size has been stored in dialog settings.
     *
     * @return the initial size of the shell
     */
    @Override
    protected Point getInitialSize() {
        final int h = 350;
        final int w = 350;
        return new Point(h, w);
    }

    /**
     * Creates the buttons for the button bar.
     *
     * @param parent the Composite
     */
    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.OK_ID,
                IDialogConstants.OK_LABEL, true);
    }
}
