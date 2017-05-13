package com.veminal.pdf.actions;

import com.veminal.pdf.actions.menu.format.AssemblyPDFAction;
import com.veminal.pdf.actions.menu.format.BuildFragmentAction;
import com.veminal.pdf.actions.menu.format.ExtractNumberAction;
import com.veminal.pdf.actions.menu.format.InjectFragmentAction;
import com.veminal.pdf.actions.menu.format.SearchAction;
import com.veminal.pdf.actions.menu.format.SelectFragmentAction;
import com.veminal.pdf.actions.menu.format.SplitPageAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the "Format" menu.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FormatActionsList implements IEventList {
    /**
     * Returns a list of actions.
     *
     * @return action list
     */
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> formatList = new ArrayList<>();
        IEvent selectFragment = new SelectFragmentAction();
        IEvent split = new SplitPageAction();
        IEvent extractNumber = new ExtractNumberAction();
        IEvent build = new BuildFragmentAction();
        IEvent inject = new InjectFragmentAction();
        IEvent assembly = new AssemblyPDFAction();
        IEvent search = new SearchAction();
        formatList.add(selectFragment);
        formatList.add(split);
        formatList.add(extractNumber);
        formatList.add(build);
        formatList.add(inject);
        formatList.add(assembly);
        formatList.add(search);
        return formatList;
    }
}
