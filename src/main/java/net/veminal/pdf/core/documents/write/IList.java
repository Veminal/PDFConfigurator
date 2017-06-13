package net.veminal.pdf.core.documents.write;

/**
 * File list interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IList {
    /**
     * Add file to list.
     *
     * @param path the String
     */
    void addFile(String path);

    /**
     * Get file list.
     *
     * @param <T> the generic
     * @return T
     */
    <T> T getList();
}
