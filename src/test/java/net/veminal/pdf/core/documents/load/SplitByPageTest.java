package net.veminal.pdf.core.documents.load;

import org.junit.Test;

/**
 * Split PDF by page.
 *
 * @author Veminal
 * @version 1.0
 */
public class SplitByPageTest {

    @Test
    public void splitTest() {
        final String input = "C:\\users\\user\\desktop\\test.pdf";
        final String output = "C:\\users\\user\\desktop\\test\\";
        ISplit split = new SplitByPage(input, output);
        split.extract();
        assert true;
    }
}
