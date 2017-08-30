package net.veminal.pdf.ui.text;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import javax.annotation.PostConstruct;

/**
 * Abstract text field.
 *
 * @author Veminal
 * @version 1.0
 */
public abstract class AbstractText {
    /**
     * Text field object.
     */
    private Text textField;

    /**
     * Setup text fields.
     *
     * @param parent the Composite
     */
    @PostConstruct
    public void createContents(final Composite parent) {
        textField = configTextField(parent);
    }

    /**
     * Configuration text field.
     *
     * @param parent the Composite
     * @return text field
     */
    protected abstract Text configTextField(Composite parent);

    /**
     * Set enabled.
     *
     * @param variant the boolean
     */
    public void enabled(final boolean variant) {
        textField.setEnabled(variant);
    }

}
