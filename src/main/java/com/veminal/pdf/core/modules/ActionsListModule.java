package com.veminal.pdf.core.modules;

import com.google.inject.AbstractModule;
import com.veminal.pdf.actions.EditActionsList;
import com.veminal.pdf.actions.FileActionsList;
import com.veminal.pdf.actions.FormatActionsList;
import com.veminal.pdf.actions.HelpActionsList;
import com.veminal.pdf.actions.IEventList;
import com.veminal.pdf.core.annotations.EditList;
import com.veminal.pdf.core.annotations.FileList;
import com.veminal.pdf.core.annotations.FormatList;
import com.veminal.pdf.core.annotations.HelpList;

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
    }
}
