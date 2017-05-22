package com.veminal.pdf.actions.menu.format;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "Assembly PDF".
 *
 * @author Veminal
 * @version 1.0
 */
public final class AssemblyPDFAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("assembly.pdf")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
