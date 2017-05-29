package net.veminal.pdf.core.documents;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.DocumentModule;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.Before;
import org.junit.Test;

/**
 * PDF create test.
 *
 * @author Veminal
 * @version 1.0
 */
public class CreatePDFDocumentTest {

    private IDocumentCreator createDoc;

    private PDPage page;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new DocumentModule());
        createDoc = injector.getInstance(CreatePDFDocument.class);
        page = injector.getInstance(PDPage.class);
    }

    @Test
    public void addPageTest() {
        createDoc.createPage(page);
        assert true;
    }

    @Test
    public void saveTest() {
        final String name ="test.pdf";
        createDoc.saveDocument(name);
        assert true;
    }

    @Test
    public void testCloseDocument() {
        createDoc.close();
        assert true;
    }
}
