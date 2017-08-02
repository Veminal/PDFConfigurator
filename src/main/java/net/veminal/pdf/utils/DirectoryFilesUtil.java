package net.veminal.pdf.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * File list in directory.
 *
 * @author Veminal
 * @version 1.0
 */
public final class DirectoryFilesUtil {
    /**
     * Empty constructor.
     */
    private DirectoryFilesUtil() {
    }

    /**
     * Get list files.
     *
     * @param paths the List
     * @return fileList
     */
    public static List<List<String>> fileList(final List<String> paths) {
        List<List<String>> files = new ArrayList<>();
        for (String path : paths) {
            try {
                files.add(Files.readAllLines(Paths.get(path),
                        StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return files;
    }
}
