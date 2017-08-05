package net.veminal.pdf.utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Pages counter.
 */
public final class NumbersUtil {
    /**
     * Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(NumbersUtil.class);

    /**
     * Empty constructor.
     */
    private NumbersUtil() {
    }

    /**
     * Pages counter method.
     *
     * @param file the String
     * @return pages count
     */
    public static int pagesCount(final String file) {
        try {
            PdfDocument document = new PdfDocument(new PdfReader(file));
            logger.info("Pages - " + document.getNumberOfPages());
            return document.getNumberOfPages();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return 0;
    }
}
