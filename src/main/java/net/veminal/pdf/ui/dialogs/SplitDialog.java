package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.SplitFileTable;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.core.documents.split.ISplit;
import net.veminal.pdf.core.documents.split.SplitByPage;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.utils.FilesUtil;
import net.veminal.pdf.utils.OpenPDFUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
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
 * Split dialog window.
 *
 * @author Veminal
 * @version 1.0
 */
public final class SplitDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig readConfig;
    /**
     * Path to file.
     */
    private final String path;
    /**
     * Default path.
     */
    private final String defaultPath;
    /**
     * Text file name.
     */
    private Text textFile;
    /**
     * Text target catalog.
     */
    private Text textTargetDirectory;
    /**
     * File table.
     */
    private AbstractTable fileTable;
    /**
     * Select all button to table.
     */
    private Button selectAllButton;
    /**
     * Submit button.
     */
    private Button submitButton;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param read        the ReadConfig
     * @param pathToFile  the String
     * @param defPath     the String
     * @param table       the AbstractTable
     */
    @Inject
    public SplitDialog(final Shell parentShell,
                       @StringReader final ReadConfig read,
                       final String pathToFile, final String defPath,
                       @SplitFileTable final AbstractTable table) {
        super(parentShell);
        this.readConfig = read;
        this.path = pathToFile;
        this.defaultPath = defPath;
        this.fileTable = table;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        readConfig.readPath(path);
        newShell.setText((String) readConfig.parse(
                "split.dialog.title"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 400;
        final int w = 450;
        return new Point(h, w);
    }

    @Override
    protected Control createDialogArea(final Composite parent) {
        final int column = 3;
        GridLayout gridLayout = new GridLayout(column, false);
        Composite area = (Composite) super.createDialogArea(parent);
        Composite composite = new Composite(area, SWT.NONE);
        composite.setLayout(gridLayout);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createInputFileName(composite);
        createInputTargetFile(composite);
        createSplitButton(composite);
        createSelectAllButton(parent);
        createTable(parent);
        return area;
    }

    /**
     * Create input file name.
     *
     * @param parent the Composite
     */
    private void createInputFileName(final Composite parent) {
        Label labelName = new Label(parent, SWT.NONE);
        readConfig.readPath(path);
        labelName.setText((String) readConfig.parse("file.name"));
        textFile = new Text(parent, SWT.BORDER);
        Button btnPdfFile = new Button(parent, SWT.PUSH);
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        readConfig.readPath(path);
        btnPdfFile.setText((String) readConfig.parse("show.catalog"));
        textFile.setLayoutData(data);
        btnPdfFile.setLayoutData(new GridData(GridData.FILL));
        btnPdfFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent event) {
                final String extensionsPath = FilesUtil.getExtensions();
                OpenPDFUtil.initializer();
                AbstractFileDialog openDialog = new OpenDialog(
                        OpenPDFUtil.getReadArray(), extensionsPath);
                openDialog.creating(SWT.OPEN);
                final String filename = openDialog.getPath();
                if (filename != null) {
                    textFile.setText(filename);
                }
            }
        });
    }

    /**
     * Create input target catalog.
     *
     * @param parent the Composite
     */
    private void createInputTargetFile(final Composite parent) {
        Label labelTarget = new Label(parent, SWT.NONE);
        readConfig.readPath(path);
        labelTarget.setText((String) readConfig.parse("target.catalog"));
        textTargetDirectory = new Text(parent, SWT.BORDER);
        Button btnTargetFile = new Button(parent, SWT.PUSH);
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        readConfig.readPath(path);
        btnTargetFile.setText((String) readConfig.parse("show.catalog"));
        textTargetDirectory.setLayoutData(data);
        btnTargetFile.setLayoutData(new GridData(GridData.FILL));
        readConfig.readPath(defaultPath);
        textTargetDirectory.setText((String) readConfig.parse(
                "default.path"));
        textTargetDirectory.setLayoutData(data);
        btnTargetFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent event) {
                DirectoryDialog directory = new DirectoryDialog(
                        Display.getCurrent().getActiveShell());
                final String defaultCatalog = textTargetDirectory.getText();
                directory.setFilterPath(defaultCatalog);
                final String target = directory.open();
                if (target != null) {
                    textTargetDirectory.setText(target + "\\");
                }
            }
        });
    }

    /**
     * Create split button.
     *
     * @param parent the Composite
     */
    private void createSplitButton(final Composite parent) {
        Button splitButton = new Button(parent, SWT.PUSH);
        splitButton.setLayoutData(new GridData(GridData.BEGINNING));
        readConfig.readPath(path);
        splitButton.setText((String) readConfig.parse("split.button"));
        Image image = new Image(Display.getCurrent(), "images/split_page.png");
        splitButton.setImage(image);
        splitButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent event) {
                Button btnCheck = (Button) event.getSource();
                final String filename = textFile.getText();
                final String target = textTargetDirectory.getText();
                if (filename != null && target != null) {
                    Runnable splitThread = () -> {
                        fileTable.updateTable();
                        btnCheck.setEnabled(false);
                        ISplit splitByPage = new SplitByPage(filename, target);
                        splitByPage.extract();
                        fileTable.items(target);
                    };
                    splitThread.run();
                }
                btnCheck.setEnabled(true);
                submitButton.setEnabled(true);
                selectAllButton.setEnabled(true);
            }
        });
    }

    /**
     * Create file browser.
     *
     * @param parent the Composite
     */
    private void createTable(final Composite parent) {
        fileTable.createContents(parent);
        fileTable.enabled(true);
    }

    /**
     * Create select all button.
     *
     * @param parent the Composite
     */
    @SuppressWarnings("all")
    private void createSelectAllButton(final Composite parent) {
        selectAllButton = new Button(parent, SWT.CHECK);
        readConfig.readPath(path);
        selectAllButton.setText((String) readConfig.parse("select.all.button"));
        selectAllButton.setLayoutData(new GridData(GridData.BEGINNING));
        selectAllButton.setEnabled(false);
        selectAllButton.setSelection(false);
        selectAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                Button buttonCheck = (Button) e.getSource();
                if (buttonCheck.getSelection()) {
                    fileTable.setItemsChecked();
                } else fileTable.disableItemCheck();
            }
        });
    }

    @Override
    protected void createButtonsForButtonBar(final Composite parent) {
        super.createButtonsForButtonBar(parent);
        submitButton = getButton(IDialogConstants.OK_ID);
        submitButton.setText(IDialogConstants.OK_LABEL);
        submitButton.setEnabled(false);
    }

    @Override
    protected void okPressed() {
        super.okPressed();
    }
}
