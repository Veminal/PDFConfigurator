package com.veminal.pdf.app;

import com.veminal.pdf.ui.frame.Frame;
import org.eclipse.swt.widgets.Shell;

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
     *
     * @param args of String[]
     */
    public static void main(final String[] args) {
        Frame frame = new Frame();
        frame.run();
    }
}
