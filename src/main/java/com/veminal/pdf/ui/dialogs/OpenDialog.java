package com.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.ArrayReader;

/**
 * Open file dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class OpenDialog extends AbstractFileDialog {
    /**
     * Array reader.
     */
    private final ReadConfig extensionReader;

    /**
     * Inject array reader.
     *
     * @param reader the ReadConfig
     */
    @Inject
    public OpenDialog(@ArrayReader final ReadConfig reader) {
        this.extensionReader = reader;
    }

    @Override
    protected String[] readExtensions() {
        extensionReader.readPath("extensions.json");
        return (String[]) extensionReader.
                parse("open.format");
    }
}
