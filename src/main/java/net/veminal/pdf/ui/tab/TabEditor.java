package net.veminal.pdf.ui.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

/**
 * Tab editor class.
 *
 * @author Veminal
 * @version 1.0
 */
public final class TabEditor extends AbstractTab {

    @Override
    protected CTabFolder configTabFolder(final Composite parent) {
        CTabFolder folder = new CTabFolder(parent, SWT.BORDER | SWT.CLOSE);
        folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        return folder;
    }

    @Override
    protected CTabItem configTabItem(final Composite parent) {
        return null;
    }
}
