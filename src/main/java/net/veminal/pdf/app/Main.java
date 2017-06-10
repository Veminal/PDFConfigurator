package net.veminal.pdf.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.actions.EditActionsList;
import net.veminal.pdf.actions.FileActionsList;
import net.veminal.pdf.actions.FormatActionsList;
import net.veminal.pdf.actions.HelpActionsList;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.actions.PopupTableActionList;
import net.veminal.pdf.actions.ToolbarActionsList;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.configuration.read.ReadDataInt;
import net.veminal.pdf.configuration.read.ReadDataList;
import net.veminal.pdf.configuration.write.WriteConfig;
import net.veminal.pdf.configuration.write.WriteDataSize;
import net.veminal.pdf.core.modules.ActionsListModule;
import net.veminal.pdf.core.modules.UIModule;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.core.modules.ToolbarModule;
import net.veminal.pdf.ui.Frame;
import net.veminal.pdf.ui.tab.AbstractTab;
import net.veminal.pdf.ui.tab.TabEditor;
import net.veminal.pdf.ui.table.AbstractTable;
import net.veminal.pdf.ui.table.FileTableBrowser;

/**
 * Application run class.
 *
 * @author Veminal
 * @version 1.0
 */
final class Main {
    /**
     * Private empty constructor.
     */
    private Main() {
    }

    /**
     * Application in entry point.
     *
     * @param args of String[]
     */
    public static void main(final String[] args) {
        final String path = "dictionary.json";
        final String pathImages = "images.json";
        final String sizePath = "app.json";
        Injector injectObject = Guice.createInjector(new ConfigurationModule(),
                new ActionsListModule(), new ToolbarModule(),
                new UIModule());
        ReadConfig readTitles = injectObject.getInstance(ReadDataFields.class);
        ReadConfig readImage = injectObject.getInstance(ReadDataList.class);
        ReadConfig readSize = injectObject.getInstance(ReadDataInt.class);
        WriteConfig writeSize = injectObject.getInstance(WriteDataSize.class);
        IEventList fileMenu = injectObject.getInstance(FileActionsList.class);
        IEventList editMenu = injectObject.getInstance(EditActionsList.class);
        IEventList formatMenu = injectObject.getInstance(
                FormatActionsList.class);
        IEventList toolbarAction = injectObject.getInstance(
                ToolbarActionsList.class);
        IEventList helpMenu = injectObject.getInstance(HelpActionsList.class);
        IEventList tableContextMenu = injectObject.getInstance(
                PopupTableActionList.class);
        AbstractTable browser = injectObject.getInstance(
                FileTableBrowser.class);
        AbstractTab tab = injectObject.getInstance(TabEditor.class);
        Frame frame = new Frame(readTitles, readImage, path,
                pathImages, fileMenu, editMenu, formatMenu,
                helpMenu, toolbarAction, browser, tab, readSize,
                sizePath, writeSize, tableContextMenu);
        frame.run();
    }
}
