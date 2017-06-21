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
        List<String> listFiles = new ArrayList<>();
        assert files != null;
        for (File f : files) {
            listFiles.add(f.getName() + " (" + path.getPath() + ")");
        }
        return listFiles;
    }
}
