package feng.LongestPalindromicSubstring;


// Expand Around Center
// 这个解法基于两个事实
// 1.回文串都是对称的。如果回文串长度为奇数，则关于中间的字符对称，如果是偶数，则关于中间的两个字符对称，且中间的两个字符是一样的
// 例如，aba，关于中间的b对称。abba，关于中间的两个b对称。
// 2.如果一个子串是回文子串，则它向左和向右各拓展一个字符，如果这两个字符相同，那拓展后的子串也是回文子串
// 例如cabba。中间的bb是回文子串，向左向右各拓展一个字符的话，左右新拓展的字符都是a，所以拓展之后的abba也是回文子串
public class MainClass2
{
    public static void main(String[] args)
    {
        MainClass2 self = new MainClass2();
        System.out.println(self.longestPalindrome("babad"));
    }

    public String longestPalindrome(String s)
    {
        String result = "";
        for (int i = 0;i <= s.length() - 1;i++)
        {
            String oddPalindrome = extendFromCenter(s,i,i);
            String evenPalindrome = extendFromCenter(s,i,i + 1);
            if (oddPalindrome.length() > evenPalindrome.length())
            {
                if (oddPalindrome.length() > result.length())
                {
                    result = oddPalindrome;
                }
            }
            else
            {
                if (evenPalindrome.length() > result.length())
                {
                    result = evenPalindrome;
                }
            }
        }
        return result;
    }

    public String extendFromCenter(String s,int leftCenter,int rightCenter)
    {
        if (leftCenter < 0 || rightCenter > s.length() - 1)
        {
            return "";
        }
        int leftIndex = leftCenter;
        int rightIndex = rightCenter;
        while (true)
        {
            if (leftIndex < 0 || rightIndex > s.length() - 1)
            {
                leftIndex = leftIndex + 1;
                rightIndex = rightIndex - 1;
                break;
            }
            char currentLeftChar = s.charAt(leftIndex);
            char currentRightChar = s.charAt(rightIndex);
            if (currentLeftChar == currentRightChar)
            {
                leftIndex = leftIndex - 1;
                rightIndex = rightIndex + 1;
            }
            else
            {
                leftIndex = leftIndex + 1;
                rightIndex = rightIndex - 1;
                break;
            }
        }
        return s.substring(leftIndex,rightIndex + 1);
    }
}
