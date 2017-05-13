package com.veminal.pdf.actions;

import com.veminal.pdf.actions.menu.file.CreateFileAction;
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
    /**
     * Returns a list of actions.
     *
     * @return action list
     */
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> fileMenuList = new ArrayList<>();
        IEvent create = new CreateFileAction();
        IEvent open = new OpenFileAction();
        IEvent save = new SaveFileAction();
        IEvent saveAs = new SaveAsAction();
        IEvent exit = new ExitAction();
        fileMenuList.add(create);
        fileMenuList.add(open);
        fileMenuList.add(save);
        fileMenuList.add(saveAs);
        fileMenuList.add(exit);
        return fileMenuList;
    }
}
