package net.veminal.pdf.ui.table;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Split file browser.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitFileTableBrowser extends AbstractTable {
    @Override
    protected List outFilesList(final String target) {
        File path = new File(target);
        File[] files = path.listFiles();
        assert files != null;
        List<String> listFiles = new ArrayList<>();
        for (File f : files) {
            listFiles.add(f.getAbsolutePath());
        }
        listFiles.sort((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        });
        return listFiles;
    }
}
