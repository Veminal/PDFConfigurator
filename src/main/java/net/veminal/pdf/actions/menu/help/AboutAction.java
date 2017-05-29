package net.veminal.pdf.actions.menu.help;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.actions.IEvent;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.annotations.NotUsed;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.dialogs.AboutDialog;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;

/**
 * Action for menu item "About".
 *
 * @author Veminal
 * @version 1.0
 */
public final class AboutAction implements IEvent {
    @Override
    public Action initializing(final ReadConfig menuItemsName) {
        return new Action((String) menuItemsName.parse("about")) {
            @Override
            public void run() {
                super.run();
                final String path = "dictionary.json";
                Injector injectObject = Guice.createInjector(
                        new ConfigurationModule());
                ReadConfig readText = injectObject.getInstance(
                        ReadDataFields.class);
                AboutDialog dialog = new AboutDialog(
                        Display.getCurrent().getActiveShell(), readText, path);
                dialog.open();
            }
        };
    }

    @Override
    @NotUsed
    public Action initializing(final ReadConfig objName, final String path) {
        return null;
    }
}
