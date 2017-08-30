package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import net.veminal.pdf.core.annotations.FileTable;
import net.veminal.pdf.core.annotations.MergeFileTable;
import net.veminal.pdf.core.annotations.PageTable;
import net.veminal.pdf.core.annotations.SplitFileTable;
import net.veminal.pdf.ui.tab.AbstractTab;
import net.veminal.pdf.ui.tab.TabEditor;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.FileTableBrowser;
import net.veminal.pdf.ui.table.MergeTable;
import net.veminal.pdf.ui.table.PageTableBrowser;
import net.veminal.pdf.ui.table.SplitFileTableBrowser;

/**
 * UI module.
 *
 * @author Veminal
 * @version 1.0
 */
public final class UIModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AbstractTable.class).annotatedWith(FileTable.class)
                .to(FileTableBrowser.class);
        bind(AbstractTable.class).annotatedWith(SplitFileTable.class)
                .to(SplitFileTableBrowser.class);
        bind(AbstractTable.class).annotatedWith(PageTable.class)
                .to(PageTableBrowser.class);
        bind(AbstractTable.class).annotatedWith(MergeFileTable.class)
                .to(MergeTable.class);
        bind(AbstractTab.class).to(TabEditor.class);
    }
}
