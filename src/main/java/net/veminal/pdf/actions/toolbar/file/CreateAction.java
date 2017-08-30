package net.veminal.pdf.actions.toolbar.file;

import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.NotUsed;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Action for button "New".
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreateAction implements IEvent {

    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("create"),
                ImageDescriptor.createFromFile(null, path)) {
        };
    }
}
