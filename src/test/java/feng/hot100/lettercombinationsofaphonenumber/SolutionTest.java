package feng.hot100.lettercombinationsofaphonenumber;

import org.junit.jupiter.api.Test;

public class SolutionTest
{
    @Test
    public void test()
    {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("2"));
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("234"));
        System.out.println(solution.letterCombinations("79"));
    }
}
