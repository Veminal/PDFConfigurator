package net.veminal.pdf.configuration.read;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.ConfigurationModule;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Read data array test.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataArrayTest {

    private ReadConfig readConfig;

    @Before
    public void setUp() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule());
        readConfig = injectMenu.getInstance(ReadDataArray.class);
    }

    @Test
    public void result() {
        final String path = "images.json";
        readConfig.readPath(path);
        final String result[] = (String[]) readConfig.parse("path");
        final String[] wait = {
                "images/new.png",
                "images/open.png",
                "images/save.png",
                "images/print.png",
                "images/del.png",
                "images/cut.png",
                "images/copy.png",
                "images/paste.png",
                "images/font.png",
                "images/cut_number.png",
                "images/fragment_select.png",
                "images/split_page.png",
                "images/merge.png",
                "images/build.png",
                "images/inject.png",
                "images/settings.png"
        };
        assertArrayEquals(wait, result);
    }
}
