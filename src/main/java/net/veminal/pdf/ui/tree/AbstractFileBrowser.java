package net.veminal.pdf.ui.tree;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import javax.annotation.PostConstruct;

/**
 * Abstract class for file browser.
 *
 * @author Veminal
 * @version 1.0
 */
public abstract class AbstractFileBrowser {
    /**
     * Tree viewer.
     */
    private TreeViewer viewer;

    /**
     * Tree configuration.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        viewer.setContentProvider(contentProvider());
        viewer.setLabelProvider(labelProvider());
        viewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true, true));
    }

    /**
     * Tree label.
     *
     * @return tree label
     */
    protected abstract ILabelProvider labelProvider();

    /**
     * Tree content.
     *
     * @return tree content
     */
    protected abstract ITreeContentProvider contentProvider();

    /**
     * Set input.
     *
     * @param object the T
     * @param <T>    the generic type
     */
    public <T> void addFileInfo(final T object) {
        viewer.setInput(object);
    }
}
