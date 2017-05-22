package com.veminal.pdf.ui.toolbar;

import com.google.inject.Inject;
import com.veminal.pdf.actions.IEvent;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.configuration.read.ReadConfig;
import com.veminal.pdf.core.annotations.ListReader;
import com.veminal.pdf.core.annotations.StringReader;
import com.veminal.pdf.core.annotations.Toolbar;
import org.eclipse.jface.action.ToolBarManager;

import java.util.List;

/**
 * Toolbar initializer.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ToolbarBuild implements ITool {
    /**
     * Read config fields.
     */
    private final ReadConfig readText;
    /**
     * Read config image.
     */
    private final ReadConfig readImage;
    /**
     * Read config actions.
     */
    private final IEventList actions;

    /**
     * Inject config constructor.
     *
     * @param text        the ReadConfig
     * @param image       the ReadConfig
     * @param actionsList the IEventList
     */
    @Inject
    public ToolbarBuild(@StringReader final ReadConfig text,
                        @ListReader final ReadConfig image,
                        @Toolbar final IEventList actionsList) {
        this.readText = text;
        this.readImage = image;
        this.actions = actionsList;
    }

    @Override
    public ToolBarManager initial() {
        final String path = "dictionary.json";
        final String pathImages = "images.json";
        ToolBarManager manager = new ToolBarManager();
        readImage.readPath(pathImages);
        List images = (List) readImage.parse("path");
        List<IEvent> toolList = actions.getActionList();
        int i = 0;
        for (IEvent action : toolList) {
            readText.readPath(path);
            manager.add(action.initializing(readText, (String) images.get(i)));
            i++;
        }
        toolList.clear();
        images.clear();
        return manager;
    }
}
