package feng.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

public class MainClass3
{
    public static void main(String[] args)
    {
        MainClass3 self = new MainClass3();
        int result = self.lengthOfLongestSubstring("jbpnbwwd");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s)
    {
        if (null == s || "".equals(s))
        {
            return 0;
        }
        if (s.length() == 1)
        {
            return 1;
        }

        Set<Character> usedChar = new HashSet<>();
        int currentMaxLength = 0;
        for (int i = 0;i < s.length() - 1;i++)
        {
            usedChar.add(s.charAt(i));
            for (int j = i + 1;j < s.length();j++)
            {
                char currentChar = s.charAt(j);
                if (usedChar.contains(currentChar))
                {
                    if (currentMaxLength < usedChar.size())
                    {
                        currentMaxLength = usedChar.size();
                    }
                    usedChar.clear();
                    break;
                }
                else
                {
                    usedChar.add(currentChar);
                }
            }
            if (currentMaxLength < usedChar.size())
            {
                currentMaxLength = usedChar.size();
            }
            usedChar.clear();;
        }

        return currentMaxLength;
    }
}
