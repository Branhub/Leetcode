package feng.Tests;

public class IndexOfTest
{
    public static void main(String[] args)
    {
        String s = "abcdeabcda";
        System.out.println(s.indexOf('a'));
        System.out.println(s.indexOf('a',0));
        System.out.println(s.indexOf('a',1));
        System.out.println(s.indexOf('a',9));
        System.out.println(s.indexOf('a',10));
    }
}
