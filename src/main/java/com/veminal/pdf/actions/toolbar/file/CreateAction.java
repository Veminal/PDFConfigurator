package com.veminal.pdf.actions.toolbar.file;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.configuration.read.ReadDataFields;
import com.veminal.pdf.core.annotations.NotUsed;
import com.veminal.pdf.core.modules.ConfigurationModule;
import com.veminal.pdf.ui.dialogs.CreatePDFProjectDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

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
        return new Action((String) objName.parse("new"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readTitles = injectObject.getInstance(
                        ReadDataFields.class);
                CreatePDFProjectDialog dialog =
                        new CreatePDFProjectDialog(Display.getCurrent()
                                .getActiveShell(), readTitles);
                dialog.open();
            }
        };
    }
}
