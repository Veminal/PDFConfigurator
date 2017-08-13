package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.MergeFileTable;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.ui.table.AbstractTable;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Merge dialog window.
 *
 * @author Veminal
 * @version 1.0
 */
public final class MergeDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig config;
    /**
     * Path to file config.
     */
    private final String path;
    /**
     * File list table.
     */
    private final AbstractTable fileTable;
    /**
     * Path to directory.
     */
    private Text textDirectory;
    /**
     * Select all button.
     */
    private Button selectAllBtn;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param readConfig  the ReadConfig
     * @param filePath    the String
     * @param table       the AbstractTable
     */
    @Inject
    public MergeDialog(final Shell parentShell,
                       @StringReader final ReadConfig readConfig,
                       final String filePath,
                       @MergeFileTable final AbstractTable table) {
        super(parentShell);
        this.config = readConfig;
        this.path = filePath;
        this.fileTable = table;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        config.readPath(path);
        newShell.setText((String) config.parse("title.merge.dialog"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 400;
        final int w = 450;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int column = 1;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createText(composite);
        createSelectAllButton(composite);
        createTable(composite);
        createButtonMerge(composite);
        return area;
    }

    /**
     * Create table.
     *
     * @param parent the Composite
     */
    private void createTable(final Composite parent) {
        fileTable.createContents(parent);
        fileTable.enabled(true);
    }

    /**
     * Create text.
     *
     * @param parent the Composite
     */
    private void createText(final Composite parent) {
        Label pathLabel = new Label(parent, SWT.NONE);
        config.readPath(path);
        pathLabel.setText((String) config.parse("target.catalog"));
        textDirectory = new Text(parent, SWT.BORDER);
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        Button btnTarget = new Button(parent, SWT.PUSH);
        config.readPath(path);
        Image image = new Image(Display.getCurrent(), "images/open.png");
        btnTarget.setText((String) config.parse("open.directory.button"));
        btnTarget.setImage(image);
        textDirectory.setLayoutData(data);
        btnTarget.setLayoutData(new GridData(GridData.FILL));
        btnTarget.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(
                        Display.getCurrent().getActiveShell());
                final String directory = dialog.open();
                if (directory != null) {
                    textDirectory.setText(directory + "\\");
                    Runnable showFiles = () ->
                            fileTable.items(textDirectory.getText());
                    showFiles.run();
                }
                selectAllBtn.setEnabled(true);
            }
        });
    }

    /**
     * Create merge button.
     *
     * @param parent the Composite
     */
    private void createButtonMerge(final Composite parent) {
        Button btnMerge = new Button(parent, SWT.PUSH);
        config.readPath(path);
        btnMerge.setText((String) config.parse("merge.button"));
        Image image = new Image(Display.getCurrent(), "images/merge.png");
        btnMerge.setImage(image);
        btnMerge.setLayoutData(new GridData(GridData.END));
        btnMerge.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                super.widgetSelected(e);
            }
        });
    }

    /**
     * Create select all button.
     *
     * @param parent the Composite
     */
    private void createSelectAllButton(final Composite parent) {
        selectAllBtn = new Button(parent, SWT.CHECK);
        config.readPath(path);
        selectAllBtn.setText((String) config.parse("select.all.button"));
        selectAllBtn.setLayoutData(new GridData(GridData.BEGINNING));
        selectAllBtn.setEnabled(false);
        selectAllBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                Button buttonCheck = (Button) e.getSource();
                if (buttonCheck.getSelection()) {
                    fileTable.setItemsChecked();
                } else {
                    fileTable.disableItemCheck();
                }
            }
        });
    }
}
