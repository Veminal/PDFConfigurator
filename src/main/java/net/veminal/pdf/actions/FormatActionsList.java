package net.veminal.pdf.actions;

import net.veminal.pdf.actions.menu.format.AssemblyPDFAction;
import net.veminal.pdf.actions.menu.format.BuildFragmentAction;
import net.veminal.pdf.actions.menu.format.ExtractNumberAction;
import net.veminal.pdf.actions.menu.format.InjectFragmentAction;
import net.veminal.pdf.actions.menu.format.SearchAction;
import net.veminal.pdf.actions.menu.format.SelectFragmentAction;
import net.veminal.pdf.actions.menu.format.SplitPageAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of actions for the "Format" menu.
 *
 * @author Veminal
 * @version 1.0
 */
public final class FormatActionsList implements IEventList {
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
