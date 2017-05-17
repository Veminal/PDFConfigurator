package com.veminal.pdf.settings.read;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing a class to read a string from a JSON file.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataFieldsTest {
    /**
     * Test for reading fields from a JSON file.
     */
    @Test
    public void returnString() {
        final String path = "dictionary.json";
        ReadSettings<String> readString = new ReadDataFields(path);
        final String result = readString.parse("menu.file");
        final String wait = "&File";
        assertEquals(wait, result);
    }
}
