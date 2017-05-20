package com.veminal.pdf.configuration.read;

/**
 * Interface for reading configuration.
 *
 * @param <T> of generic type
 * @author Veminal
 * @version 1.0
 */
public interface ReadConfig<T> {
    /**
     * Read path to file.
     *
     * @param path the String
     */
    void readPath(String path);

    /**
     * Reading data by key.
     *
     * @param key of String
     * @return configuration data
     */
    T parse(String key);
}
