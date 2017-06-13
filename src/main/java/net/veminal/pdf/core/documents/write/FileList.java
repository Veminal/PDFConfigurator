package net.veminal.pdf.core.documents.write;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
     * Logger.
     */
    private Logger logger = LoggerFactory.getLogger(FileList.class);
    /**
     * File list.
     */
    private List<List<String>> list = new ArrayList<>();

    @Override
    public void addFile(final String path) {
        try {
            List<String> files = Files.readAllLines(Paths.get(path),
                    StandardCharsets.UTF_8);
            list.add(files);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<List<String>> getList() {
        return list;
    }
}
