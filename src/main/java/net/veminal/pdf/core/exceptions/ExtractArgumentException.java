package net.veminal.pdf.core.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extract argument exception.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExtractArgumentException extends Exception {
    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(
            ExtractArgumentException.class);
    /**
     * Name.
     */
    private final String name;

    /**
     * Constructor of class.
     *
     * @param m1 the String
     */
    public ExtractArgumentException(final String m1) {
        this.name = m1;
    }

    /**
     * Get String.
     *
     * @return name
     */
    public String getName() {
        return name;
    }
}
