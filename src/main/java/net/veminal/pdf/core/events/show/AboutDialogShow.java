package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AboutDialog;
import net.veminal.pdf.utils.FilesUtil;
import org.eclipse.swt.widgets.Display;

/**
 * Show About dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class AboutDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String path = FilesUtil.getDictionary();
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        AboutDialog dialog = new AboutDialog(Display.getCurrent()
                .getActiveShell(), read, path);
        dialog.open();
    }
}
