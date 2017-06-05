package net.veminal.pdf.configuration.write;

import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Write integer config.
 *
 * @author Veminal
 * @version 1.0
 */
public final class WriteDataSize implements WriteConfig {
    /**
     * Json writer.
     */
    private JsonWriter writer;

    @Override
    public void readToPath(final String path) {
        try {
            writer = new JsonWriter(new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData(final int object, final int object2,
                          final String key, final String key2) {
        try {
            writer.beginObject();
            writer.name(key).value(object);
            writer.name(key2).value(object2);
            writer.endObject();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
