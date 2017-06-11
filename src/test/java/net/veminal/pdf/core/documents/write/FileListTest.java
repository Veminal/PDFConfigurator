package net.veminal.pdf.core.documents.write;

import org.junit.Before;
import org.junit.Test;

/**
 * File files testing.
 *
 * @author Veminal
 * @version 1.0
 */
public class FileListTest {

    private IList list;

    @Before
    public void setUp() {
        list = new FileList();
    }

    @Test
    public void addFileTest() {
        final String firstFile = "app.json";
        final String secondFile = "README.md";
        final String thirdFile = "LICENSE";
        list.addFile(firstFile);
        list.addFile(secondFile);
        list.addFile(thirdFile);
        assert true;
    }
}
