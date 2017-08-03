package net.veminal.pdf.core.events.show;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.core.modules.UIModule;
import net.veminal.pdf.ui.dialogs.MergeDialog;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.MergeTable;
import net.veminal.pdf.utils.FilesUtil;
import org.eclipse.swt.widgets.Display;

/**
 * Show MergeDialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class MergeDialogShow implements ShowDialog {
    @Override
    public void create() {
        final String path = FilesUtil.getDictionary();
        final String def = FilesUtil.getDefault();
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule(), new UIModule());
        ReadConfig read = injectObject.getInstance(
                ReadDataFields.class);
        AbstractTable table = injectObject.getInstance(MergeTable.class);
        MergeDialog mergeDialog = new MergeDialog(
                Display.getCurrent().getActiveShell(), read, path, def, table);
        mergeDialog.open();
    }
}
