package net.veminal.pdf.core.documents.split;

import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.layout.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Extract the page by number.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExtractPageByNumber implements ISplit {
    /**
     * Logger.
     */
    private Logger logger =
            LoggerFactory.getLogger(ExtractPageByNumber.class);
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
     * File name.
     */
    private final String fileNameTarget;

    /**
     * Constructor of class.
     *
     * @param file the String
     * @param n    the int
     * @param t    the String
     * @param name the String
     */
    public ExtractPageByNumber(final String file, final int n, final String t, final String name) {
        this.filename = file;
        this.number = n;
        this.target = t;
        this.fileNameTarget = name;
    }

    @Override
    public void extract() {
        logger.info("extract page");
        try {
            PdfReader reader = new PdfReader(filename);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
