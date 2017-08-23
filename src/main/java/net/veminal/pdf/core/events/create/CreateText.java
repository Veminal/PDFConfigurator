package net.veminal.pdf.core.events.create;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Text;

/**
 * Create text line.
 *
 * @author Veminal
 * @version 1.0
 */
public final class CreateText implements ICreate<CTabItem> {
    /**
     * Composite object.
     */
    private final CTabFolder composite;

    /**
     * Constructor of class.
     *
     * @param parent the Composite
     */
    public CreateText(final CTabFolder parent) {
        this.composite = parent;
    }

    @Override
    public CTabItem generation() {
        CTabItem item = new CTabItem(composite, SWT.CLOSE);
        Text text = new Text(composite, SWT.MULTI);
        item.setControl(text);
        return item;
    }
}
