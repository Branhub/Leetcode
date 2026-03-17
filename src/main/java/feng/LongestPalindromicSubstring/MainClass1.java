package feng.LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainClass1
{
    public static void main(String[] args)
    {
        MainClass1 self = new MainClass1();
        System.out.println(self.longestPalindrome("cccccccccc"));
    }

    public String longestPalindrome(String s)
    {
        String result = "";
        Set<Character> examed = new HashSet<>();
        for (int i = 0; i < s.length();i++)
        {
            char currentChar = s.charAt(i);
            if (examed.contains(currentChar))
            {
                continue;
            }
            else
            {
                examed.add(currentChar);
                List<Integer> allIndex = getAllIndex(s,currentChar);
                if (allIndex.size() == 1)
                {
                    // 如果整个字符串里只有一个该字符，那它本身就是回文串
                    if (result.length() < 1)
                    {
                        result = String.valueOf(currentChar);
                    }
                    continue;
                }
                for (int j = 0; j < allIndex.size(); j++)
                {
                    for (int k = allIndex.size() - 1;k > j;k--)
                    {
                        String sub = s.substring(allIndex.get(j),allIndex.get(k)+1);
                        boolean ifPalindrome = ifPalindrome(sub);
                        if (ifPalindrome && result.length() < sub.length())
                        {
                            result = sub;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean ifPalindrome(String s)
    {
        boolean result = true;
        int topIndex = s.length() / 2;
        for (int i = 0;i < topIndex;i++)
        {
            char headChar = s.charAt(i);
            char tailChar = s.charAt(s.length() - 1 - i);
            if (headChar != tailChar)
            {
                result = false;
                break;
            }
        }

        return result;
    }

    public List<Integer> getAllIndex(String s, char c)
    {
        List<Integer> result = new ArrayList<>();
        int currentIndex = s.indexOf(c);
        while (currentIndex != -1)
        {
            result.add(currentIndex);
            currentIndex = s.indexOf(c,currentIndex + 1);
        }
        return result;
    }
}
