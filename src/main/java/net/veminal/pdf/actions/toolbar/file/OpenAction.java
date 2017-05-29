package net.veminal.pdf.actions.toolbar.file;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataArray;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AbstractFileDialog;
import net.veminal.pdf.ui.dialogs.OpenDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;

/**
 * Action for button "Open".
 *
 * @author Veminal
 * @version 1.0
 */
public final class OpenAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("open"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                final String path = "extensions.json";
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readArray = injectObject.getInstance(
                        ReadDataArray.class);
                AbstractFileDialog openDialog = new OpenDialog(readArray, path);
                openDialog.creating(SWT.OPEN);
            }
        };
    }
}
