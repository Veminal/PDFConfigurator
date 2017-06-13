package net.veminal.pdf.core.documents.write;

import com.google.inject.Inject;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
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
public final class CreatePDFParagraph implements IDocumentCreate {
    /**
     * Logger.
     */
    private Logger logger =
            LoggerFactory.getLogger(CreatePDFParagraph.class);
    /**
     * List file path.
     */
    private final List<List<String>> files;

    /**
     * Constructor of class.
     * @param fileList the IList
     */
    @Inject
    public CreatePDFParagraph(final IList fileList) {
        this.files = fileList.getList();
    }

    @Override
    public void saveFile(final String name) {
        try {
            PdfWriter writer = new PdfWriter(name);
            PdfDocument document = new PdfDocument(writer);
            Document pdf = new Document(document);
            for (List<String> file : files) {
                for (String line: file) {
                    pdf.add(new Paragraph(line));
                }
            }
            pdf.close();
        } catch (FileNotFoundException e) {
            MessageDialog.openError(Display.getCurrent().getActiveShell(),
                    "Error create", e.getMessage());
            logger.error(e.getMessage());
        }
    }
}
