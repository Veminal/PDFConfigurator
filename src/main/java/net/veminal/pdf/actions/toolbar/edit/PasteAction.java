package net.veminal.pdf.actions.toolbar.edit;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "Paste".
 *
 * @author Veminal
 * @version 1.0
 */
public final class PasteAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("paste"),
                ImageDescriptor.createFromFile(null, path)) {
        };
    }
}
