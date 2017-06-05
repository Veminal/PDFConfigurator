package net.veminal.pdf.configuration.write;

/**
 * Write configuration interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface WriteConfig {
    /**
     * Read path to file.
     *
     * @param path the String
     */
    void readToPath(String path);

    /**
     * Write data.
     *
     * @param object  the int
     * @param object2 the int
     * @param key     the String
     * @param key2    the String
     */
    void writeData(int object, int object2, String key, String key2);
}
