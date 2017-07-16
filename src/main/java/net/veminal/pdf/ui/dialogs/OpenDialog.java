package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.ArrayReader;

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
     * Path to file.
     */
    private final String path;

    /**
     * Inject array reader.
     *
     * @param reader     the ReadConfig
     * @param pathToFile the String
     */
    @Inject
    public OpenDialog(@ArrayReader final ReadConfig reader,
                      final String pathToFile) {
        this.extensionReader = reader;
        this.path = pathToFile;
    }

    @Override
    protected String[] readExtensions() {
        extensionReader.readPath(path);
        return (String[]) extensionReader.
                parse("create.format");
    }


}
