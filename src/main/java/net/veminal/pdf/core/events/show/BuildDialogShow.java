package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AssemblyPDFDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Show build dialog.
 * @author Veminal
 * @version 1.0
 */
public final class BuildDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String path = "dictionary.json";
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        AssemblyPDFDialog dialog = new AssemblyPDFDialog(Display.getCurrent()
                .getActiveShell(), read, path);
        dialog.open();
    }
}
