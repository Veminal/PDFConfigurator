package net.veminal.pdf.ui.toolbar;

import org.eclipse.jface.action.ToolBarManager;

/**
 * Toolbar configuration interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface ITool {
    /**
     * Toolbar components initializing.
     *
     * @return toolbar
     */
    ToolBarManager initial();
}
