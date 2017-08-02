package net.veminal.pdf.core.documents.write;

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

    /**
     * Merge two file.
     *
     * @param fileMain   the String
     * @param fileInject the String
     */
    void mergeTwoFiles(String fileMain, String fileInject);
}
