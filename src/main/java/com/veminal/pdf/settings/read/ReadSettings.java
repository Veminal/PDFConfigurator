package com.veminal.pdf.settings.read;

import java.util.List;

/**
 * Interface for reading settings.
 *
 * @param <T> of generic type
 * @author Veminal
 * @version 1.0
 */
public interface ReadSettings<T> {
    /**
     * Set descriptor array lines.
     *
     * @param descriptor of String type
     */
    void setDescriptor(String descriptor);

    /**
     * Reading data by key.
     *
     * @param key of String
     * @return settings data
     */
    T parse(String key);
}
