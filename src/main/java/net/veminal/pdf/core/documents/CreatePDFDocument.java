package net.veminal.pdf.core.documents;

import com.google.inject.Inject;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

/**
 * Create PDF Document.
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreatePDFDocument implements IDocumentCreator {
    /**
     * PDF documents object.
     */
    private PDDocument pdfDocument = new PDDocument();

    @Override
    @Inject
    public void createPage(final PDPage page) {
        if (page != null) {
            pdfDocument.addPage(page);
        }
    }

    @Override
    public void saveDocument(final String name) {
        try {
            pdfDocument.save(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            pdfDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
