package net.veminal.pdf.core.documents.merge;

import java.util.List;

/**
 * Merge interface.
 *
 * @author Veminal
 * @version 1.0
 */
public interface IMerge {
    /**
     * Merge file list.
     *
     * @param files         the T
     * @param target the T
     */
    void mergeFileList(List<String> files, String target);
}
