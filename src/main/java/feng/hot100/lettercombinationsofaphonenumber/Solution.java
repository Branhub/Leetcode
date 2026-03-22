
package feng.hot100.lettercombinationsofaphonenumber;


import java.util.*;

public class Solution {

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
        Set<String> result = new HashSet<>();
        for (int i = 0;i < digits.length(); i++)
        {
            List<Character> currentDigit = DIGIT_2_CHAR.get(digits.charAt(i));
            if (i == 0)
            {
                for (Character c : currentDigit)
                {
                    result.add(String.valueOf(c));
                }
            }
            else
            {
                Set<String> previous = new HashSet<>(result);
                result.clear();
                for (String previousOneResult : previous)
                {
                    for (Character c : currentDigit)
                    {
                        result.add(previousOneResult + c);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}