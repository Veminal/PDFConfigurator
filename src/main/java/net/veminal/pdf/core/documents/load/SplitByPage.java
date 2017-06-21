package net.veminal.pdf.core.documents.load;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PageRange;
import com.itextpdf.kernel.utils.PdfSplitter;

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
     * File name.
     */
    private final String filename;
    /**
     * Target path.
     */
    private final String target;

    /**
     * Constructor of class.
     *
     * @param file          the String
     * @param targetCatalog the String
     */
    public SplitByPage(final String file, final String targetCatalog) {
        this.filename = file;
        this.target = targetCatalog;
    }

    @Override
    public void extract() {
        try {
            final long splitBySize = Integer.SIZE;
            PdfDocument document = new PdfDocument(new PdfReader(filename));
            List<PdfDocument> splitDocuments = new PdfSplitter(document) {
                private final int n = 1;
                private int partNumber = n;
                @Override
                protected PdfWriter getNextPdfWriter(final PageRange d) {
                    try {
                        return new PdfWriter(target
                                + String.valueOf(partNumber++) + ".pdf");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.splitBySize(splitBySize);
            for (PdfDocument doc : splitDocuments) {
                doc.close();
            }
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
