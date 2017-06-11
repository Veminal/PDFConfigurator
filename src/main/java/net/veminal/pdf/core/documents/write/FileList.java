package net.veminal.pdf.core.documents.write;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Realization interface of IList.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FileList implements IList {
    /**
     * File list.
     */
    private List<List<String>> list = new ArrayList<>();

    @Override
    public void addFile(final String path) {
        try {
            List<String> s = Files.readAllLines(Paths.get(path),
                    StandardCharsets.UTF_8);
            list.add(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<List<String>> getList() {
        return list;
    }
}
