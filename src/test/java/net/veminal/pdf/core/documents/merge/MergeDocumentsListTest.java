package net.veminal.pdf.core.documents.merge;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeDocumentsListTest {

    private IMerge mergeList;
    private List<String> listPath;

    @Before
    public void setUp() {
        final String target = "C:\\Users\\user\\Desktop\\1";
        mergeList = new MergeDocumentsList(target);
        listPath = new ArrayList<>();
    }

    @Test
    public void testMerge() {
        listPath.add("C:\\Users\\user\\Desktop\\books\\UposOs.pdf");
        listPath.add("C:\\Users\\user\\Desktop\\books\\Textmetuk_OS_1.pdf");
        mergeList.mergeFileList(listPath);
        assert true;
    }
}
