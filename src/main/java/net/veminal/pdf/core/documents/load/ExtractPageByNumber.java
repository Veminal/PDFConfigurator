package net.veminal.pdf.core.documents.load;

/**
 * Extract the page by number.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExtractPageByNumber implements ISplit {
    /**
     * File name.
     */
    private final String filename;

    /**
     * Page number.
     */
    private final int number;

    /**
     * Target catalog.
     */
    private final String target;

    /**
     * Constructor of class.
     *
     * @param file the String
     * @param n    the int
     * @param t    the String
     */
    public ExtractPageByNumber(final String file, final int n, final String t) {
        this.filename = file;
        this.number = n;
        this.target = t;
    }

    @Override
    public void extract() {
    }
}
