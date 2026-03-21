
package feng.lettercombinationsofaphonenumber;


import java.util.*;

public class Solution2
{

    private static final Map<Character,List<Character>> DIGIT_2_CHAR;
    static
    {
        Map<Character,List<Character>> temp = new HashMap<>();
        temp.put('2', Arrays.asList('a','b','c'));
        temp.put('3', Arrays.asList('d','e','f'));
        temp.put('4', Arrays.asList('g','h','i'));
        temp.put('5', Arrays.asList('j','k','l'));
        temp.put('6', Arrays.asList('m','n','o'));
        temp.put('7', Arrays.asList('p','q','r','s'));
        temp.put('8', Arrays.asList('t','u','v'));
        temp.put('9', Arrays.asList('w','x','y','z'));
        DIGIT_2_CHAR = Collections.unmodifiableMap(temp);
    }

    public List<String> letterCombinations(String digits)
    {
        int[] indexes = new int[digits.length()];
        int loopTimes = 1;
        for (int i = 0; i < digits.length(); i++)
        {
            List<Character> possible = DIGIT_2_CHAR.get(digits.charAt(i));
            loopTimes = loopTimes * possible.size();
            indexes[i] = 0;
        }
        List<String> result = new ArrayList<>(loopTimes);
        for (int i = 0 ; i < loopTimes; i++)
        {
            char[] chars = new char[digits.length()];
            for (int j = 0; j < digits.length(); j++)
            {
                chars[j] = DIGIT_2_CHAR.get(digits.charAt(j)).get(indexes[j]);
            }
            result.add(new String(chars));
            for (int j = digits.length() - 1; j >= 0; j--)
            {
                int nextIndex = indexes[j] + 1;
                if (nextIndex >= DIGIT_2_CHAR.get(digits.charAt(j)).size())
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