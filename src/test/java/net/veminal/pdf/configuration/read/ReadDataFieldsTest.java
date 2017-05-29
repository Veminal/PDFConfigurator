package net.veminal.pdf.configuration.read;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.ConfigurationModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Read data fields test.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataFieldsTest {

    private ReadConfig readConfig;

    @Before
    public void setUp() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule());
        readConfig = injectMenu.getInstance(ReadDataFields.class);
    }

    @Test
    public void result() {
        final String path = "dictionary.json";
        readConfig.readPath(path);
        final String result = (String)
                readConfig.parse("settings");
        final String wait = "&Settings";
        assertEquals(wait, result);
    }
}
