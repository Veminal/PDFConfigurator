package com.veminal.pdf.settings.read;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Read menu information.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ReadDataFile implements ReadSettings<String> {
    /**
     * Read JSON file.
     */
    private JsonReader reader;

    /**
     * Constructor of class.
     * Getting the path to the file.
     *
     * @param path of String
     */
    public ReadDataFile(final String path) {
        try {
            reader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            MessageDialog.openError(new Shell(),
                    "File not found", e.getMessage());
            final int status = -1;
            System.exit(status);
        }
    }

    /**
     * Reading data by key.
     *
     * @param key of String
     * @return settings data
     */
    @Override
    public String parse(final String key) {
        JsonElement element = new JsonParser().parse(reader);
        JsonObject object = element.getAsJsonObject();
        return object.get(key).getAsString();
    }
}
