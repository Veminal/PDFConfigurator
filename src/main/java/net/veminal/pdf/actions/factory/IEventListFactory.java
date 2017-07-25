package net.veminal.pdf.actions.factory;

import net.veminal.pdf.actions.IEvent;

/**
 * Factory template generating
 * classes for building user interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IEventListFactory {
    /**
     * IEvent create.
     *
     * @return IEvent object
     */
    IEvent create();
}
