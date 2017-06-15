package net.veminal.pdf.actions;

import net.veminal.pdf.actions.popup.table.CreatePageAction;
import net.veminal.pdf.actions.popup.table.DeletePageOrDocumentAction;
import net.veminal.pdf.actions.popup.table.SplitDocumentAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Popup Table action list.
 *
 * @author Veminal
 * @version 1.0
 */
public final class PopupTableActionList implements IEventList {
    @Override
    public List<IEvent> getActionList() {
        List<IEvent> popupTableList = new ArrayList<>();
        IEvent createPage = new CreatePageAction();
        IEvent deletePageOrDocument = new DeletePageOrDocumentAction();
        IEvent splitPDF = new SplitDocumentAction();
        popupTableList.add(createPage);
        popupTableList.add(deletePageOrDocument);
        popupTableList.add(splitPDF);
        return popupTableList;
    }
}
