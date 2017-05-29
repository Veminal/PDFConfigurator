package net.veminal.pdf.configuration.read;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.veminal.pdf.core.modules.ConfigurationModule;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Read data list test.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataListTest {

    private ReadConfig readConfig;

    @Before
    public void setUp() {
        Injector injectMenu = Guice.createInjector(
                new ConfigurationModule());
        readConfig = injectMenu.getInstance(ReadDataList.class);
    }

    @Test
    public void result() {
        final String path = "images.json";
        readConfig.readPath(path);
        List result = (List)readConfig.parse("path");
        List<String> wait = new ArrayList<>();
        wait.add("images/open.png");
        wait.add("images/save.png");
        wait.add("images/del.png");
        wait.add("images/cut.png");
        wait.add("images/copy.png");
        wait.add("images/paste.png");
        wait.add("images/font.png");
        wait.add("images/cut_number.png");
        wait.add("images/fragment_select.png");
        wait.add("images/split_page.png");
        wait.add("images/build.png");
        wait.add("images/inject.png");
        wait.add("images/settings.png");
        assertEquals(wait, result);
    }
}
