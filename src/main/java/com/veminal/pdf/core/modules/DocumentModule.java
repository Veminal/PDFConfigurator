package com.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import com.veminal.pdf.core.documents.CreatePDFDocument;
import com.veminal.pdf.core.documents.IDocumentCreator;

/**
 * Dependency Configuration for PDF Working Classes.
 *
 * @author Veminal
 * @version 1.0
 */
public final class DocumentModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IDocumentCreator.class).to(CreatePDFDocument.class);
    }
}
