package net.veminal.pdf.core.documents;

import org.apache.pdfbox.pdmodel.PDPage;

/**
 * Interface for creating documents.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IDocumentCreator {
    /**
     * Creating PDF page.
     *
     * @param page the PDPage
     */
    void createPage(PDPage page);

    /**
     * Save Document.
     *
     * @param name the String
     */
    void saveDocument(String name);

    /**
     * Close pdfDocument,
     */
    void close();
}
