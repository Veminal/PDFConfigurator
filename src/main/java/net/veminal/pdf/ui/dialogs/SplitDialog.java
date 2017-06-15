package net.veminal.pdf.ui.dialogs;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataArray;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.core.modules.ConfigurationModule;
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
     * Select target catalog get text.
     */
    private String target;
    /**
     * Select filename get text.
     */
    private String filename;

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
                       final AbstractTable table) {
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
        createImportCheckButton(parent);
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
                final String extensionsPath = "extensions.json";
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readArray = injectObject.getInstance(
                        ReadDataArray.class);
                AbstractFileDialog openDialog = new OpenDialog(
                        readArray, extensionsPath);
                openDialog.creating(SWT.OPEN);
                final String file = openDialog.getPath();
                if (file != null) {
                    textFile.setText(file);
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
        btnTargetFile.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent event) {
                DirectoryDialog directory = new DirectoryDialog(
                        Display.getCurrent().getActiveShell());
                directory.setFilterPath(textTargetDirectory.getText());
                final String dir = directory.open();
                if (dir != null) {
                    textTargetDirectory.setText(dir);
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
            }
        });
    }

    /**
     * Create import check.
     *
     * @param parent the Composite
     */
    private void createImportCheckButton(final Composite parent) {
        Button btnImport = new Button(parent, SWT.CHECK);
        readConfig.readPath(path);
        btnImport.setText((String) readConfig.parse("import.button"));
        btnImport.setLayoutData(new GridData(GridData.BEGINNING));
        btnImport.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent event) {
                Button btnCheck = (Button) event.getSource();
                if (btnCheck.getSelection()) {
                    fileTable.enabled(true);
                } else {
                    fileTable.enabled(false);
                }
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
        fileTable.enabled(false);
    }

    @Override
    protected void okPressed() {
        super.okPressed();
    }
}
