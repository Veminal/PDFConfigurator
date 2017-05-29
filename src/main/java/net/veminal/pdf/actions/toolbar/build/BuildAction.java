package net.veminal.pdf.actions.toolbar.build;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AssemblyPDFDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;

/**
 * Action for button "Build".
 *
 * @author Veminal
 * @version 1.0
 */
public final class BuildAction implements IEvent {
    @Override
    @NotUsed
    public Action initializing(final ReadConfig menuItemsName) {
        return null;
    }

    @Override
    public Action initializing(final ReadConfig objName, final String path) {
        return new Action((String) objName.parse("build.fragments"),
                ImageDescriptor.createFromFile(null, path)) {
            @Override
            public void run() {
                super.run();
                final String path = "dictionary.json";
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readTitles = injectObject.getInstance(
                        ReadDataFields.class);
                AssemblyPDFDialog assemblyPDF = new AssemblyPDFDialog(
                        Display.getCurrent().getActiveShell(), readTitles, path);
                assemblyPDF.open();
            }
        };
    }
}
