package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import net.veminal.pdf.ui.tab.AbstractTab;
import net.veminal.pdf.ui.tab.TabEditor;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.FileTableBrowser;

/**
 * UI module.
 *
 * @author Veminal
 * @version 1.0
 */
public final class UIModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AbstractTable.class).to(FileTableBrowser.class);
        bind(AbstractTab.class).to(TabEditor.class);
    }
}
