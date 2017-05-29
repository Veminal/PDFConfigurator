package net.veminal.pdf.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

/**
 * Abstract class for dialogs that implement reading and saving files.
 *
 * @author Veminal
 * @version 1.0
 */
public abstract class AbstractFileDialog {
    /**
     * File dialog.
     */
    private FileDialog fileDialog;
    /**
     * Path to file.
     */
    private String path;

    /**
     * Reading file extensions.
     *
     * @return extensions
     */
    protected abstract String[] readExtensions();

    /**
     * Initialization file dialog.
     *
     * @param i the int type
     */
    public void creating(final int i) {
        if (i == SWT.OPEN) {
            fileDialog = new FileDialog(
                    Display.getCurrent().getActiveShell(), i | SWT.MULTI);
        }
        if (i == SWT.SAVE) {
            fileDialog = new FileDialog(
                    Display.getCurrent().getActiveShell(), i);
        }
        fileDialog.setFilterExtensions(readExtensions());
        path = fileDialog.open();
    }

    /**
     * Get path.
     *
     * @return path
     */
    public String getPath() {
        return path;
    }
}
