package net.veminal.pdf.utils;

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
     * get default file.
     *
     * @return default file name
     */
    public static String getDefault() {
        return "default.json";
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
}
