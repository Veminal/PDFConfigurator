package ru.veminal.pdf.app;

import org.eclipse.swt.widgets.Shell;
import ru.veminal.pdf.ui.frame.Frame;

/**
 * Application run class.
 *
 * @author Veminal
 * @version 1.0
 */
final class Main {
    /**
     * Private empty constructor.
     */
    private Main() {
    }

    /**
     * Application in entry point.
     * @param args of String[]
     */
    public static void main(final String[] args) {
        Shell shell = new Shell();
        Frame frame = new Frame(shell);
        frame.run();
    }
}
