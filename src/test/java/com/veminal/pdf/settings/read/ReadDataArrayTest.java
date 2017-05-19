package com.veminal.pdf.settings.read;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Testing a class to read an array from a JSON file.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataArrayTest {
    /**
     * A test to read an array from a JSON file.
     */
    @Test
    public void arrayResult() {
        final String path = "filters.json";
        ReadConfig<String[]> readArray = new ReadDataArray(path);
        final String[] arrayResult = readArray.parse("open.format");
        assertArrayEquals(new String[]{"*.pdf", "*.doc", "*.docx", "*.txt",
                "*.md", "*.html", "*.xml", "*.java", "*.js", "*.c",
                "*.css", "*.cpp", "*.json"}, arrayResult);
    }
}
