package net.veminal.pdf.ui.tab;

import org.eclipse.swt.custom.CTabFolder;
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
     * CTab object.
     */
    private CTabFolder tab;

    /**
     * Setup CTab.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        tab = configTabFolder(parent);
    }

    /**
     * Configuration setup.
     *
     * @param parent the Composite
     * @return tab folder
     */
    protected abstract CTabFolder configTabFolder(Composite parent);

    /**
     * Create tab item.
     *
     * @param t the CTab
     */
    public abstract void tabItem(CTabFolder t);
}
