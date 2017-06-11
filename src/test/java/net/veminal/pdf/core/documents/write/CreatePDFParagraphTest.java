package net.veminal.pdf.core.documents.write;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.DocumentModule;
import org.junit.Before;
import org.junit.Test;

/**
 * PDF Paragraph Test.
 *
 * @author Veminal
 * @version 1.0
 */
public class CreatePDFParagraphTest {

    private CreatePDFParagraph pdf;

    @Before
    public void setUp() {
        Injector injector = Guice.createInjector(new DocumentModule());
        IList files = injector.getInstance(FileList.class);
        files.addFile("LICENSE");
        files.addFile("dictionary.json");
        pdf = new CreatePDFParagraph(files);
    }

    @Test
    public void createTest() {
        final String name = "test.pdf";
        pdf.saveFile(name);
        assert true;
    }
}
