package net.veminal.pdf.core.documents.write;

import java.util.List;

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
     * @return T
     */
    List<List<String>> getList();
}
