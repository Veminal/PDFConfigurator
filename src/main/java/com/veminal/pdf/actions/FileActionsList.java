package com.veminal.pdf.actions;

import com.veminal.pdf.actions.menu.file.ExitAction;
import com.veminal.pdf.actions.menu.file.OpenFileAction;
import com.veminal.pdf.actions.menu.file.SaveAsAction;
import com.veminal.pdf.actions.menu.file.SaveFileAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the "File" menu.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FileActionsList implements IEventList {
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> fileMenuList = new ArrayList<>();
        IEvent open = new OpenFileAction();
        IEvent save = new SaveFileAction();
        IEvent saveAs = new SaveAsAction();
        IEvent exit = new ExitAction();
        fileMenuList.add(open);
        fileMenuList.add(save);
        fileMenuList.add(saveAs);
        fileMenuList.add(exit);
        return fileMenuList;
    }
}
