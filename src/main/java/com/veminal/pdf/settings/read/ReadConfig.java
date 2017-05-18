package com.veminal.pdf.settings.read;

/**
 * Interface for reading configuration.
 *
 * @param <T> of generic type
 * @author Veminal
 * @version 1.0
 */
public interface ReadConfig<T> {
    /**
     * Reading data by key.
     *
     * @param key of String
     * @return settings data
     */
    T parse(String key);
}
