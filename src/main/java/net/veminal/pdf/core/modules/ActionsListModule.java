package net.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import net.veminal.pdf.actions.EditActionsList;
import net.veminal.pdf.actions.FileActionsList;
import net.veminal.pdf.actions.FormatActionsList;
import net.veminal.pdf.actions.HelpActionsList;
import net.veminal.pdf.actions.IEventList;
import net.veminal.pdf.actions.PopupTableActionList;
import net.veminal.pdf.core.annotations.EditList;
import net.veminal.pdf.core.annotations.FileList;
import net.veminal.pdf.core.annotations.FormatList;
import net.veminal.pdf.core.annotations.HelpList;
import net.veminal.pdf.core.annotations.TableContext;

/**
 * Configure dependencies to work with the list of menus.
 *
 * @author Veminal
 * @version 1.0
 */
public final class ActionsListModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IEventList.class).annotatedWith(FileList.class)
                .to(FileActionsList.class);
        bind(IEventList.class).annotatedWith(EditList.class).
                to(EditActionsList.class);
        bind(IEventList.class).annotatedWith(FormatList.class)
                .to(FormatActionsList.class);
        bind(IEventList.class).annotatedWith(HelpList.class)
                .to(HelpActionsList.class);
        bind(IEventList.class).annotatedWith(TableContext.class)
                .to(PopupTableActionList.class);
    }
}
