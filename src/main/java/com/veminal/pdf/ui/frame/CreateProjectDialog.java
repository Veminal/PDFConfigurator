package com.veminal.pdf.ui.frame;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Implementation of the dialog menu for creating a project.
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreateProjectDialog extends Dialog {
    /**
     * Constructor of class.
     *
     * @param parentShell of Shell
     */
    public CreateProjectDialog(final Shell parentShell) {
        super(parentShell);
    }

    /**
     * Configures the given shell in preparation for opening this window in it.
     * The default implementation of this framework method sets the shell's
     * image and gives it a grid layout. Subclasses may extend or reimplement.
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

    /**
     * Creates and returns the contents of the upper part of this dialog (above
     * the button bar).
     * The <code>Dialog</code> implementation of this framework method creates
     * and returns a new <code>Composite</code> with standard margins and
     * spacing.
     * <p>
     * The returned control's layout data must be an instance of
     * <code>GridData</code>. This method must not modify the parent's
     * layout.
     * <p>
     * Subclasses must override this method but may call <code>super</code> as
     * in the following example:
     * <p>
     * Composite composite = (Composite) super.createDialogArea(parent);
     * //add controls to composite as necessary
     * return composite;
     *
     * @param parent the parent composite to contain the dialog area
     * @return the dialog area control
     */
    @Override
    protected Control createDialogArea(final Composite parent) {
        Composite composite = (Composite) super.createDialogArea(parent);
        return composite;
    }
}
