package net.veminal.pdf.core.documents.merge;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Create a PDF document with information collected in one page.
 *
 * @author Veminal
 * @version 1.0
 */
public final class BuildPDFDocument implements Build {
    /**
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(BuildPDFDocument.class);
    /**
     * List files paths.
     */
    private final List<List<String>> files;

    /**
     * Constructor of class.
     *
     * @param fList the List<List<String>>
     */
    public BuildPDFDocument(final List<List<String>> fList) {
        this.files = fList;
    }

    @Override
    public void buildPDF(final String name) {
        logger.info("BUILD PDF DOCUMENT");
        try {
            PdfWriter writer = new PdfWriter(name);
            PdfDocument document = new PdfDocument(writer);
            Document pdf = new Document(document);
            for (List<String> file : files) {
                for (String line : file) {
                    pdf.add(new Paragraph(line));
                    logger.info("CREATE PARAGRAPH");
                }
                logger.info("FILE COMPLETED");
            }
            pdf.close();
            logger.info("OPERATION COMPLETED");
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
