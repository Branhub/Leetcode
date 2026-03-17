package feng.Tests;

public class StringToBoolean
{
    public static void main(String[] args)
    {
        String s1 = null;
        String s2 = "";
        String s3 = "tRuE";

        System.out.println(Boolean.valueOf(s1));
        System.out.println(Boolean.valueOf(s2));
        System.out.println(Boolean.valueOf(s3));
    }
}
