package net.veminal.pdf.ui.dialogs;

import com.google.inject.Inject;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.annotations.PageTable;
import net.veminal.pdf.core.annotations.StringReader;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.utils.FilesUtil;
import net.veminal.pdf.utils.OpenPDFUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Extract by page number dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ExtractByPageNumberDialog extends Dialog {
    /**
     * Read config.
     */
    private final ReadConfig config;

    /**
     * Path to file.
     */
    private final String path;
    /**
     * Page table.
     */
    private final AbstractTable pageTable;
    /**
     * Path to main file.
     */
    private Text filePathText;
    /**
     * text from page.
     */
    private Text pageText;

    /**
     * Constructor of class.
     *
     * @param parentShell the Shell
     * @param read        the ReadConfig
     * @param pathToFile  the String
     * @param pTable      the AbstractTable
     */
    @Inject
    public ExtractByPageNumberDialog(final Shell parentShell,
                                     @StringReader final ReadConfig read,
                                     final String pathToFile,
                                     @PageTable final AbstractTable pTable) {
        super(parentShell);
        this.config = read;
        this.path = pathToFile;
        this.pageTable = pTable;
    }

    @Override
    protected void configureShell(final Shell newShell) {
        super.configureShell(newShell);
        config.readPath(path);
        newShell.setText((String) config.parse(
                "extract.pages.dialog.title"));
    }

    @Override
    protected Point getInitialSize() {
        final int h = 1000;
        final int w = 1000;
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
        createToFilePath(composite);
        createWizard(composite);
        createButtonExtract(composite);
        return area;
    }

    /**
     * Create table browser.
     *
     * @param parent the Composite
     */
    private void createWizard(final Composite parent) {
        SashForm splitter = new SashForm(parent, SWT.HORIZONTAL);
        splitter.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        pageTable.createContents(splitter);
        pageText = new Text(splitter, SWT.BORDER);
        pageText.setEnabled(false);
        pageTable.enabled(true);
    }

    /**
     * Create input file name.
     *
     * @param parent the Composite
     */
    private void createToFilePath(final Composite parent) {
        Label labelFile = new Label(parent, SWT.NONE);
        config.readPath(path);
        labelFile.setText((String) config.parse("file.name"));
        filePathText = new Text(parent, SWT.BORDER);
        Button btnPdfOpenButton = new Button(parent, SWT.PUSH);
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        config.readPath(path);
        Image image = new Image(Display.getCurrent(), "images/open.png");
        btnPdfOpenButton.setText((String) config.parse("open.button"));
        btnPdfOpenButton.setImage(image);
        filePathText.setLayoutData(data);
        btnPdfOpenButton.setLayoutData(new GridData(GridData.FILL));
        btnPdfOpenButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                OpenPDFUtil.initializer();
                final String extensions = FilesUtil.getExtensions();
                AbstractFileDialog open = new OpenDialog(
                        OpenPDFUtil.getReadArray(), extensions);
                open.creating(SWT.OPEN);
                final String file = open.getPath();
                if (file != null) {
                    filePathText.setText(file);
                }
            }
        });
    }

    /**
     * Extract button.
     *
     * @param parent the Composite
     */
    private void createButtonExtract(final Composite parent) {
        Button extractButton = new Button(parent, SWT.PUSH);
        config.readPath(path);
        Image image = new Image(Display.getCurrent(), "images/cut.png");
        extractButton.setText((String) config.parse("button.extract"));
        extractButton.setImage(image);
        GridData data = new GridData();
        data.grabExcessHorizontalSpace = true;
        data.horizontalAlignment = GridData.END;
        extractButton.setLayoutData(data);
    }
}
