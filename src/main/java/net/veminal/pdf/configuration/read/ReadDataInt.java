package net.veminal.pdf.configuration.read;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Read windows size.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ReadDataInt implements ReadConfig<Integer> {
    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(ReadDataInt.class);
    /**
     * Read JSON file.
     */
    private JsonReader reader;

    @Override
    public void readPath(final String path) {
        try {
            reader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Integer parse(final String key) {
        JsonElement element = new JsonParser().parse(reader);
        JsonObject object = element.getAsJsonObject();
        return object.get(key).getAsInt();
    }
}
