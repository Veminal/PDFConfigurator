package net.veminal.pdf.actions.menu.file;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadDataArray;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AbstractFileDialog;
import net.veminal.pdf.ui.dialogs.SaveDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 * Action for menu item "Save As...".
 *
 * @author Veminal
 * @version 1.0
 */
public final class SaveAsAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("save.as")) {
            @Override
            public void run() {
                super.run();
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readArray = injectObject.getInstance(
                        ReadDataArray.class);
                final String path = "extensions.json";
                AbstractFileDialog saveDialog = new SaveDialog(readArray, path);
                saveDialog.creating(SWT.SAVE);
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
