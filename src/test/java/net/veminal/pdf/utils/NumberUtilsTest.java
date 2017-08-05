package net.veminal.pdf.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberUtilsTest {
    @Test
    public void getNumberTest() {
        final String path = "C:\\Users\\user\\Desktop\\books\\Textmetuk_OS_1.pdf";
        final int count = NumbersUtil.pagesCount(path);
        final int countWait = 15;
        assertEquals(countWait, count);
    }
}
