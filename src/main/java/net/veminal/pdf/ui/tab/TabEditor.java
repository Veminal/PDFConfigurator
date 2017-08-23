package net.veminal.pdf.ui.tab;

import org.eclipse.swt.custom.CTabFolder;

/**
 * Create tabs for editing.
 *
 * @author Veminal
 * @version 1.0
 */
public final class TabEditor extends AbstractTab {
    /**
     * CTabFolder.
     */
    private CTabFolder folder;

    @Override
    public void tabItem(final CTabFolder t) {
        folder = t;
    }
}
