package net.veminal.pdf.core.documents.write;

import net.veminal.pdf.core.annotations.NotUsed;

import java.util.List;

/**
 * List documents merge.
 *
 * @author Veminal
 * @version 1.0
 */
public final class MergeDocumentsList implements IMerge {
    @Override
    public void mergeFileList(final List<String> files, final String target) {
    }

    @Override
    @NotUsed
    public void mergeTwoFiles(final String fileMain, final String fileInject) {
    }
}
