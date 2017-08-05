package net.veminal.pdf.utils;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Pages counter.
 *
 * @author Veminal
 * @version 1.0
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
            int count = document.getNumberOfPages();
            document.close();
            return count;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return 0;
    }

    /**
     * List numbers pages.
     *
     * @param path the Integer
     * @return numbers
     */
    public static List<Integer> getNumberPage(final String path) {
        List<Integer> numbers = new ArrayList<>();
        try {
            PdfDocument document = new PdfDocument(new PdfReader(path));
            for (int i = 1; i <= document.getNumberOfPages(); i++) {
                numbers.add(i);
                logger.info("Page - " + i);
            }
            document.close();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return numbers;
    }
}
