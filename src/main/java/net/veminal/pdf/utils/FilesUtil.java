package net.veminal.pdf.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * File names config.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FilesUtil {
    /**
     * Empty constructor.
     */
    private FilesUtil() {
    }

    /**
     * Get dictionary file.
     *
     * @return dictionary file name
     */
    public static String getDictionary() {
        return "dictionary.json";
    }

    /**
     * Fet extensions file.
     *
     * @return extensions file name
     */
    public static String getExtensions() {
        return "extensions.json";
    }

    /**
     * Get default file name.
     *
     * @return default file name
     */
    public static String getDefault() {
        return "default.json";
    }

    /**
     * Get about file name.
     *
     * @return about file name
     */
    public static String getAbout() {
        return "about.json";
    }

    /**
     * Get app file.
     *
     * @return app file name
     */
    public static String getApp() {
        return "app.json";
    }

    /**
     * Get images file.
     *
     * @return images file name
     */
    public static String getImages() {
        return "images.json";
    }

    /**
     * Get list files.
     *
     * @param target the String
     * @return file list
     */
    public static List getDefaultFileList(final String target) {
        File path = new File(target);
        File[] files = path.listFiles((dir, name) ->
                name.toLowerCase().endsWith(".pdf"));
        assert files != null;
        List<String> listFiles = new ArrayList<>();
        for (File f : files) {
            listFiles.add(f.getAbsolutePath());
        }
        listFiles.sort(Comparator.comparingInt(String::length));
        return listFiles;
    }

    /**
     * Get default name.
     *
     * @return name
     */
    public static String getDefaultName() {
        return "__Page";
    }
}
