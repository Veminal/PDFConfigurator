package com.veminal.pdf.ui.toolbar;

import org.eclipse.jface.action.ToolBarManager;

/**
 * Toolbar configuration interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface ITool {
    /**
     * Create toolbar item.
     *
     * @return ToolBarManager
     */
    ToolBarManager init();
}
