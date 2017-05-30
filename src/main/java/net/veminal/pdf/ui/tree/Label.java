package net.veminal.pdf.ui.tree;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 * Tree label provider.
 *
 * @author Veminal
 * @version 1.0
 */
public final class Label implements ILabelProvider {
    @Override
    public Image getImage(final Object element) {
        return null;
    }

    @Override
    public String getText(final Object element) {
        return null;
    }

    @Override
    public void addListener(final ILabelProviderListener listener) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isLabelProperty(final Object element,
                                   final String property) {
        return false;
    }

    @Override
    public void removeListener(final ILabelProviderListener listener) {
    }
}
