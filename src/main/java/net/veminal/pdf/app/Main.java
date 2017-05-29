package net.veminal.pdf.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataFields;
import net.veminal.pdf.core.modules.ConfigurationModule;
import net.veminal.pdf.ui.frame.Frame;

/**
 * Application run class.
 *
 * @author Veminal
 * @version 1.0
 */
final class Main {
    /**
     * Private empty constructor.
     */
    private Main() {
    }

    /**
     * Application in entry point.
     *
     * @param args of String[]
     */
    public static void main(final String[] args) {
        final String path = "dictionary.json";
        final String pathImages = "images.json";
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule());
        ReadConfig readTitles = injectObject.getInstance(
                ReadDataFields.class);
        Frame frame = new Frame(readTitles, path, pathImages);
        frame.run();
    }
}
