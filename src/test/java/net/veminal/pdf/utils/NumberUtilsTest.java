package net.veminal.pdf.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberUtilsTest {

    @Test
    public void getNumbersTest() {
        final String path = "C:\\Users\\user\\Desktop\\books\\Textmetuk_OS_1.pdf";
        final int count = NumbersUtil.pagesCount(path);
        final int countWait = 15;
        assertEquals(countWait, count);
    }

    @Test
    public void getListNumbers() {
        final String path = "C:\\Users\\user\\Desktop\\books\\Textmetuk_OS_1.pdf";
        List<Integer> numbers = NumbersUtil.getNumberPage(path);
        List<Integer> numbersWait = new ArrayList<>();
        final int wait = 16;
        for (int i = 1; i != wait; i++) {
            numbersWait.add(i);
        }
        assertEquals(numbersWait, numbers);
    }
}
