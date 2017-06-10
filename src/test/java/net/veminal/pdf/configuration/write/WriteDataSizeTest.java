package net.veminal.pdf.configuration.write;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.ConfigurationModule;
import org.junit.Before;
import org.junit.Test;

/**
 * Test write config.
 *
 * @author Veminal
 * @version 1.0
 */
public class WriteDataSizeTest {

    private WriteConfig writeConfig;

    @Before
    public void setUp() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule());
        writeConfig = injectMenu.getInstance(WriteDataSize.class);
    }

    @Test
    public void writeTest() {
        final String key1 = "window.height";
        final int height = 800;
        final String key2 = "window.width";
        final int width = 600;
        String path = "app.json";
        writeConfig.readToPath(path);
        writeConfig.writeData(height, width, key1, key2);
        assert true;
    }
}
