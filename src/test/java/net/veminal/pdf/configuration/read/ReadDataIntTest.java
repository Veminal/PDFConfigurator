package net.veminal.pdf.configuration.read;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.ConfigurationModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Read data int.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataIntTest {

    private ReadConfig readConfig;

    private final String path = "app.json";

    @Before
    public void setUp() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule());
        readConfig = injectMenu.getInstance(ReadDataInt.class);
    }

    @Test
    public void readHeight() {
        readConfig.readPath(path);
        final int result = (int) readConfig.parse("window.height");
        final int wait = 800;
        assertEquals(wait, result);
    }

    @Test
    public void readWidth() {
        readConfig.readPath(path);
        final int result = (int) readConfig.parse("window.width");
        final int wait = 600;
        assertEquals(wait, result);
    }
}
