package array;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {


    @Test
    public void reverse() {
        int[] a = { 1, 2, 3, 4, 5, 6};
        Util.reverse(a, 0, a.length - 1);
        int[] b = { 6, 5, 4, 3, 2, 1};
        assertTrue(Arrays.equals(a, b));
        int[] aa = { 1, 2, 3, 4, 5, 6};
        Util.reverse(aa, 2, 5);
        int[] bb = { 1, 2, 6, 5, 4, 3};
        assertTrue(Arrays.equals(aa, bb));
    }

    @Test
    public void palindrom() {
        char[] a = "Hollo".toCharArray();
        assertTrue(Util.isPalindrom(a, 1, 4));
        char[] aa = "Hollw".toCharArray();
        assertFalse(Util.isPalindrom(aa, 1, 4));
    }

    @Test
    public void palindrome1() {
        char[] aaa = "animallootsfoliateddetailofstoollamina".toCharArray();
        assertTrue(Util.isPalindrom(aaa, 0, aaa.length - 1));
    }
}
