package net.veminal.pdf.utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.configuration.read.ReadConfig;
import net.veminal.pdf.configuration.read.ReadDataArray;
import net.veminal.pdf.core.modules.ConfigurationModule;

/**
 * Open PDF dialog.
 *
 * @author Veminal
 * @version 1.0
 */
public final class OpenPDFUtil {
    /**
     * Read config.
     */
    private static ReadConfig readArray;

    /**
     * Empty constructor.
     */
    private OpenPDFUtil() {
    }

    /**
     * Initializing objects.
     */
    public static void initializer() {
        Injector injectObject = Guice.createInjector(
                new ConfigurationModule());
        readArray = injectObject.getInstance(
                ReadDataArray.class);
    }

    /**
     * Get read config.
     *
     * @return readArray
     */
    public static ReadConfig getReadArray() {
        return readArray;
    }
}
