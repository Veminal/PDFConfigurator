package net.veminal.pdf.actions;

import java.util.List;

/**
 * Action list interface.
 * Create an actions list.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IEventList {
    /**
     * Returns a list of actions.
     *
     * @return action list
     */
    List<IEvent> getActionList();
}
