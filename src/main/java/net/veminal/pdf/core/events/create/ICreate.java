package net.veminal.pdf.core.events.create;

/**
 * Create object.
 *
 * @param <T> the Generic
 * @author Veminal
 * @version 1.0
 */
public interface ICreate<T> {
    /**
     * Generation object.
     *
     * @return T
     */
    T generation();
}
