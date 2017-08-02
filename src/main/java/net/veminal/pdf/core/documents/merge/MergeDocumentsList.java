package net.veminal.pdf.core.documents.merge;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * List documents merge.
 *
 * @author Veminal
 * @version 1.0
 */
public final class MergeDocumentsList implements IMerge {
    /**
     * Name for target document.
     */
    private final String name;
    /**
     * Logger.
     */
    private Logger logger =
            LoggerFactory.getLogger(MergeDocumentsList.class);

    /**
     * Constructor of class.
     *
     * @param nameDoc the String
     */
    public MergeDocumentsList(final String nameDoc) {
        this.name = nameDoc;
    }

    @Override
    public void mergeFileList(final List<String> files, final String target) {
        logger.info("MERGE DOCUMENTS LIST");
        try {
            final int firstPage = 1;
            PdfDocument documentTarget = new PdfDocument(
                    new PdfWriter(target + name + ".pdf"));
            for (String path : files) {
                PdfDocument documentMain = new PdfDocument(new PdfReader(path));
                documentMain.copyPagesTo(firstPage,
                        documentMain.getNumberOfPages(), documentTarget);
                documentMain.close();
                logger.info(path + " -COPIED");
            }
            documentTarget.close();
            files.clear();
            logger.info("COMPLETED");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
