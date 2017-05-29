package net.veminal.pdf.ui.menu;

import org.eclipse.jface.action.MenuManager;

/**
 * Menu configuration interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IMenu {
    /**
     * Create menu item.
     *
     * @return menu
     */
    MenuManager initial();
}
