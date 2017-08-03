package net.veminal.pdf.core.documents.split;

import org.junit.Test;

public class ExtractPageByNumberTest {

    @Test
    public void extractTest() {
        final int pageNumber = 1;
        final String filename = "C:\\Users\\user\\Desktop\\books\\UposOs.pdf";
        final String target = "C:\\Users\\user\\Desktop\\";
        final String name = "Copy";
        ExtractPageByNumber pageByNumber =
                new ExtractPageByNumber(filename, pageNumber, target, name);
        pageByNumber.extract();
        assert true;
    }
}
