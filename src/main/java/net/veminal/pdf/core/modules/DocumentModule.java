package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
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
    }
}
