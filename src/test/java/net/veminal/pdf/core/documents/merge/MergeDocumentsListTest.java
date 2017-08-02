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
        mergeList = new MergeDocumentsList("Merge");
        listPath = new ArrayList<>();
    }

    @Test
    public void testMerge() {
        listPath.add("C:\\Users\\user\\Desktop\\books\\UposOs.pdf");
        listPath.add("C:\\Users\\user\\Desktop\\books\\Textmetuk_OS_1.pdf");
        final String target = "C:\\Users\\user\\Desktop\\";
        mergeList.mergeFileList(listPath, target);
        assert true;
    }
}
