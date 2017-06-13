package net.veminal.pdf.core.documents.load;

/**
 * Read document interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface ISplit {
    /**
     * Load document for split by page.
     *
     * @param filename the String
     */
    void loadDocument(String filename);

    /**
     * Load document for extract by number.
     *
     * @param filename the String
     * @param number   the int
     */
    void loadDocument(String filename, int number);
}
