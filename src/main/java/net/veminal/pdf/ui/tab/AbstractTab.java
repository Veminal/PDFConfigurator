package net.veminal.pdf.ui.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import javax.annotation.PostConstruct;

/**
 * Abstract class for tabs.
 *
 * @author Veminal
 * @version 1.0
 */
public abstract class AbstractTab {
    /**
     * CTab initializing.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        CTabFolder tabFolder = new CTabFolder(parent, SWT.BORDER);
        tabFolder.setLayoutData(new GridData(
                SWT.FILL, SWT.FILL, true, true));
    }

    /**
     * Create tab item.
     *
     * @param t the CTab
     * @param i the int
     */
    public abstract void tabItem(CTabFolder t, int i);
}
