package net.veminal.pdf.ui.tab;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
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
     * @param parent the Composite
     * @return tab item
     */
    protected abstract CTabItem configTabItem(Composite parent);

    /**
     * Set tab item.
     */
    public void setTabItem() {
        configTabItem(tab);
    }

    /**
     * Set tab folder enabled.
     *
     * @param variant the boolean
     */
    public void enabled(final boolean variant) {
        tab.setEnabled(variant);
    }
}
