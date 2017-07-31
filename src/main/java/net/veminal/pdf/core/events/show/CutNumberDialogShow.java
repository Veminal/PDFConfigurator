package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.core.modules.UIModule;
import net.veminal.pdf.ui.dialogs.ExtractByPageNumberDialog;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.PageTableBrowser;
import org.eclipse.swt.widgets.Display;

/**
 * Cut number dialog show.
 *
 * @author Veminal
 * @version 1.0
 */
public final class CutNumberDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String path = "dictionary.json";
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule(), new UIModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        AbstractTable table = injectObject.getInstance(PageTableBrowser.class);
        ExtractByPageNumberDialog dialog = new ExtractByPageNumberDialog(
                Display.getCurrent().getActiveShell(), read, path, table);
        dialog.open();
    }
}
