package com.veminal.pdf.actions;

import com.veminal.pdf.actions.toolbar.build.BuildAction;
import com.veminal.pdf.actions.toolbar.build.InjectAction;
import com.veminal.pdf.actions.toolbar.edit.CopyAction;
import com.veminal.pdf.actions.toolbar.edit.CutAction;
import com.veminal.pdf.actions.toolbar.edit.FontAction;
import com.veminal.pdf.actions.toolbar.edit.PasteAction;
import com.veminal.pdf.actions.toolbar.file.CreateAction;
import com.veminal.pdf.actions.toolbar.file.DeleteAction;
import com.veminal.pdf.actions.toolbar.file.OpenAction;
import com.veminal.pdf.actions.toolbar.file.SaveAction;
import com.veminal.pdf.actions.toolbar.settings.SettingsAction;
import com.veminal.pdf.actions.toolbar.split.CutNumberAction;
import com.veminal.pdf.actions.toolbar.split.FragmentAction;
import com.veminal.pdf.actions.toolbar.split.SplitPageAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the toolbar.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ToolbarActionsList implements IEventList {
    /**
     * Returns a list of actions.
     *
     * @return action list
     */
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> toolbarList = new ArrayList<>();
        IEvent create = new CreateAction();
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
        toolbarList.add(create);
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
