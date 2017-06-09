package net.veminal.pdf.actions;

import net.veminal.pdf.actions.menu.file.CreateFileAction;
import net.veminal.pdf.actions.menu.file.ExitAction;
import net.veminal.pdf.actions.menu.file.OpenFileAction;
import net.veminal.pdf.actions.menu.file.PrintFileAction;
import net.veminal.pdf.actions.menu.file.SaveAsAction;
import net.veminal.pdf.actions.menu.file.SaveFileAction;

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
        IEvent create = new CreateFileAction();
        IEvent open = new OpenFileAction();
        IEvent save = new SaveFileAction();
        IEvent saveAs = new SaveAsAction();
        IEvent print = new PrintFileAction();
        IEvent exit = new ExitAction();
        fileMenuList.add(create);
        fileMenuList.add(open);
        fileMenuList.add(save);
        fileMenuList.add(saveAs);
        fileMenuList.add(print);
        fileMenuList.add(exit);
        return fileMenuList;
    }
}
