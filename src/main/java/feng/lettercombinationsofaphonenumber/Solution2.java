
package feng.lettercombinationsofaphonenumber;


import java.util.*;

@SuppressWarnings("unused")
public class Solution2
{

    private static final char[][] DIGIT_2_CHAR;
    static
    {
        DIGIT_2_CHAR = new char[][]
        {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };
    }

    public List<String> letterCombinations(String digits)
    {
        int[] indexes = new int[digits.length()];
        int loopTimes = 1;
        for (int i = 0; i < digits.length(); i++)
        {
            loopTimes = loopTimes * DIGIT_2_CHAR[digits.charAt(i) - 50].length;
            indexes[i] = 0;
        }
        List<String> result = new ArrayList<>(loopTimes);
        for (int i = 0 ; i < loopTimes; i++)
        {
            char[] chars = new char[digits.length()];
            for (int j = 0; j < digits.length(); j++)
            {
                chars[j] = DIGIT_2_CHAR[digits.charAt(j) - 50][indexes[j]];
            }
            result.add(new String(chars));
            for (int j = digits.length() - 1; j >= 0; j--)
            {
                int nextIndex = indexes[j] + 1;
                if (nextIndex >= DIGIT_2_CHAR[digits.charAt(j) - 50].length)
                {
                    indexes[j] = 0;
                }
                else
                {
                    indexes[j] = nextIndex;
                    break;
                }
            }
        }
        return result;
    }
}