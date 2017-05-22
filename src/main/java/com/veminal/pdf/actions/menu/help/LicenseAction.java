package com.veminal.pdf.actions.menu.help;

import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;

/**
 * Action for menu item "License".
 *
 * @author Veminal
 * @version 1.0
 */
public final class LicenseAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("license")) {
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
