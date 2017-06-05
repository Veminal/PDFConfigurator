package net.veminal.pdf.core.exceptions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Exception handling for PDF processing.
 *
 * @author Veminal
 * @version 1.0
 */
public final class PDFException extends Exception {
    /**
     * Constructor of class.
     */
    public PDFException() {
        super();
    }

    /**
     * Output message.
     */
    public void message() {
        MessageDialog.openError(Display.getCurrent().getActiveShell(),
                "PDF Error",
                "The file does not have an extension .pdf");
    }
}
