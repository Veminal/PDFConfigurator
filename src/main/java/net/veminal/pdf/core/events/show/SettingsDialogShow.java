package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.SettingsDialog;
import net.veminal.pdf.utils.FilesUtil;
import org.eclipse.swt.widgets.Display;

/**
 * Settings show dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SettingsDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String pathToFile = FilesUtil.getDictionary();
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        SettingsDialog dialog = new SettingsDialog(Display.getCurrent()
                .getActiveShell(), pathToFile, read);
        dialog.open();
    }
}
