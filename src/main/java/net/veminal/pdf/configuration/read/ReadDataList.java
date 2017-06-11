package net.veminal.pdf.configuration.read;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public final class ReadDataList implements ReadConfig<List<String>> {
    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(ReadDataList.class);
    /**
     * Read JSON file.
     */
    private JsonReader listReader;

    @Override
    public void readPath(final String path) {
        try {
            listReader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<String> parse(final String key) {
        JsonObject jObject = (JsonObject) new JsonParser().parse(listReader);
        JsonArray array = jObject.getAsJsonArray(key);
        Type listType = new TypeToken<List<String>>() {
        }.getType();
        return new Gson().fromJson(array, listType);
    }
}
