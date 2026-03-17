package feng.Tests;

import java.util.SortedMap;

public class SplitTest
{
    public static void main(String[] args)
    {
//        String s = "abcd";
//        String s = "abcda";
//        String s = "abcdb";
//        String s = "adbcd";
        String s = "aabcdaaacdaa";
        System.out.println(s.split("b").length);
        System.out.println(s.split("a").length);
        System.out.println(s.split("d").length);
    }
}
