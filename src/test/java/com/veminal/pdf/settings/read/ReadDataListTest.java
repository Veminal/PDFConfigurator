package com.veminal.pdf.settings.read;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing a class to read a list from a JSON file.
 *
 * @author Veminal
 * @version 1.0
 */
public class ReadDataListTest {
    /**
     * A test to read a list from a JSON file.
     */
    @Test
    public void resultList() {
        final String path = "filter.json";
        ReadConfig<List<String>> readList = new ReadDataList(path);
        final List resultList = readList.parse("open.format");
        List<String> waitList = new ArrayList<>();
        waitList.add("*.pdf");
        waitList.add( "*.doc");
        waitList.add("*.docx");
        waitList.add("*.txt");
        assertEquals(waitList, resultList);
    }
}
