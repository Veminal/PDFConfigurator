package com.veminal.pdf.actions.toolbar.file;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.configuration.read.ReadDataArray;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.core.modules.ConfigurationModule;
import com.veminal.pdf.ui.dialogs.AbstractFileDialog;
import com.veminal.pdf.ui.dialogs.OpenDialog;
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
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readArray = injectObject.getInstance(
                        ReadDataArray.class);
                AbstractFileDialog openDialog = new OpenDialog(readArray);
                openDialog.creating(SWT.OPEN);
            }
        };
    }
}
