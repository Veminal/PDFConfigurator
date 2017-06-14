package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import net.veminal.pdf.core.annotations.Number;
import net.veminal.pdf.core.annotations.Page;
import net.veminal.pdf.core.documents.load.ExtractPageByNumber;
import net.veminal.pdf.core.documents.load.ISplit;
import net.veminal.pdf.core.documents.load.SplitByPage;
import net.veminal.pdf.core.documents.write.FileList;
import net.veminal.pdf.core.documents.write.IList;

/**
 * Dependency Configuration for PDF Working Classes.
 *
 * @author Veminal
 * @version 1.0
 */
public final class DocumentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IList.class).to(FileList.class);
        bind(ISplit.class).annotatedWith(Page.class).to(SplitByPage.class);
        bind(ISplit.class).annotatedWith(Number.class)
                .to(ExtractPageByNumber.class);
    }
}
