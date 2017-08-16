package net.veminal.pdf.core.documents.split;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PageRange;
import com.itextpdf.kernel.utils.PdfSplitter;
import net.veminal.pdf.utils.FilesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Split PDF document.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitByPage implements ISplit {
    /**
     * Logger.
     */
    private Logger logger =
            LoggerFactory.getLogger(SplitByPage.class);
    /**
     * File name.
     */
    private final String filename;
    /**
     * Target path.
     */
    private final String target;
    /**
     * File target name.
     */
    private final String fileTargetName;

    /**
     * Constructor of class.
     *
     * @param file          the String
     * @param targetCatalog the String
     * @param fileTarget    the String
     */
    public SplitByPage(final String file, final String targetCatalog,
                       final String fileTarget) {
        this.filename = file;
        this.target = targetCatalog;
        fileTargetName = fileTarget;
    }

    @Override
    public void extract() {
        logger.info("Split pages");
        try {
            final long splitBySize = Integer.SIZE;
            PdfDocument document = new PdfDocument(new PdfReader(filename));
            List<PdfDocument> splitDocuments = new PdfSplitter(document) {
                private final int n = 1;
                private int partNumber = n;

                @Override
                protected PdfWriter getNextPdfWriter(final PageRange d) {
                    try {
                        logger.info("New page - " + partNumber + ".pdf");
                        return new PdfWriter(target
                                + fileTargetName + FilesUtil.getDefaultName()
                                + String.valueOf(partNumber++) + ".pdf");
                    } catch (FileNotFoundException e) {
                        logger.error(e.getMessage());
                    }
                    return null;
                }
            }.splitBySize(splitBySize);
            for (PdfDocument doc : splitDocuments) {
                doc.close();
            }
            document.close();
            logger.info("OPERATION COMPLETED");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
