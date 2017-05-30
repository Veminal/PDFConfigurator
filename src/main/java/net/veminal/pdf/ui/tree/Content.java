package net.veminal.pdf.ui.tree;

import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * Tree content provider.
 *
 * @author Veminal
 * @version 1.0
 */
public final class Content implements ITreeContentProvider {
    @Override
    public Object[] getElements(final Object inputElement) {
        return new Object[0];
    }

    @Override
    public Object[] getChildren(final Object parentElement) {
        return new Object[0];
    }

    @Override
    public Object getParent(final Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(final Object element) {
        return false;
    }
}
