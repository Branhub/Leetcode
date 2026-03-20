
package feng.lettercombinationsofaphonenumber;


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
        Set<String> resultSet = new HashSet<>();
        char[] oneResult = new char[digits.length()];
        int[] indexes = new int[digits.length()];
        int[] targetIndexes = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++)
        {
            indexes[i] = 0;
            targetIndexes[i] = DIGIT_2_CHAR.get(digits.charAt(i)).size() - 1;
        }
        while ()
        {

        }
    }

    public boolean allFound(int[] indexes,int[] targetIndexes)
    {
        for (int i = 0; i < indexes.length; i++)
        {
            if (indexes[i] != targetIndexes[i])
            {
                return false;
            }
        }
        return true;
    }
}