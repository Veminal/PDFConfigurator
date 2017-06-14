package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.core.modules.UIModule;
import net.veminal.pdf.ui.dialogs.SplitDialog;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.FileTableBrowser;
import org.eclipse.swt.widgets.Display;

/**
 * Split dialog show.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String path = "dictionary.json";
        final String defaultPath = "default.json";
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule(), new UIModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        AbstractTable table = injectObject.getInstance(FileTableBrowser.class);
        SplitDialog dialog = new SplitDialog(Display.getCurrent()
                .getActiveShell(), read, path, defaultPath, table);
        dialog.open();
    }
}
