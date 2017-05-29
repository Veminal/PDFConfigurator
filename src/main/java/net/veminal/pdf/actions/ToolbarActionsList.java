package net.veminal.pdf.actions;

import net.veminal.pdf.actions.toolbar.build.BuildAction;
import net.veminal.pdf.actions.toolbar.build.InjectAction;
import net.veminal.pdf.actions.toolbar.edit.CopyAction;
import net.veminal.pdf.actions.toolbar.edit.CutAction;
import net.veminal.pdf.actions.toolbar.edit.FontAction;
import net.veminal.pdf.actions.toolbar.edit.PasteAction;
import net.veminal.pdf.actions.toolbar.file.DeleteAction;
import net.veminal.pdf.actions.toolbar.file.OpenAction;
import net.veminal.pdf.actions.toolbar.file.SaveAction;
import net.veminal.pdf.actions.toolbar.settings.SettingsAction;
import net.veminal.pdf.actions.toolbar.split.CutNumberAction;
import net.veminal.pdf.actions.toolbar.split.FragmentAction;
import net.veminal.pdf.actions.toolbar.split.SplitPageAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the toolbar.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ToolbarActionsList implements IEventList {
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> toolbarList = new ArrayList<>();
        IEvent open = new OpenAction();
        IEvent save = new SaveAction();
        IEvent delete = new DeleteAction();
        IEvent cut = new CutAction();
        IEvent copy = new CopyAction();
        IEvent paste = new PasteAction();
        IEvent font = new FontAction();
        IEvent cutNumber = new CutNumberAction();
        IEvent fragment = new FragmentAction();
        IEvent splitPage = new SplitPageAction();
        IEvent build = new BuildAction();
        IEvent inject = new InjectAction();
        IEvent settings = new SettingsAction();
        toolbarList.add(open);
        toolbarList.add(save);
        toolbarList.add(delete);
        toolbarList.add(cut);
        toolbarList.add(copy);
        toolbarList.add(paste);
        toolbarList.add(font);
        toolbarList.add(cutNumber);
        toolbarList.add(fragment);
        toolbarList.add(splitPage);
        toolbarList.add(build);
        toolbarList.add(inject);
        toolbarList.add(settings);
        return toolbarList;
    }
}
