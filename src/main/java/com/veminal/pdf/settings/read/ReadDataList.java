package com.veminal.pdf.settings.read;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Read menu list information.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ReadDataList implements ReadSettings<List<String>> {
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
    public ReadDataList(final String path) {
        try {
            reader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            MessageDialog.openError(new Shell(),
                    "File not found", e.getMessage());
        }
    }

    /**
     * Reading data by key.
     *
     * @param key of String
     * @return settings data
     */
    @Override
    public List<String> parse(final String key) {
        JsonObject jObject = (JsonObject) new JsonParser().parse(reader);
        JsonArray array = jObject.getAsJsonArray(key);
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(array, listType);
    }
}