package feng.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


//Approach 2: Sliding Window Algorithm
// To check if a character is already in the substring, we can scan the substring, which leads to an O(n^2) algorithm. But we can do better.
// By using HashSet as a sliding window, checking if a character in the current can be done in O(1).
// A sliding window is an abstract concept commonly used in array/string problems.
// A window is a range of elements in the array/string which usually defined by the start and end indices,
// i.e. [i,j) (left-closed, right-open).
// A sliding window is a window "slides" its two boundaries to the certain direction.
// For example, if we slide [i,j) to the right by 111 element, then it becomes [i+1,j+1) (left-closed, right-open).
// Back to our problem.
// We use HashSet to store the characters in current window [i,j) (j=i initially).
// Then we slide the index j to the right. If it is not in the HashSet, we slide j further.
// Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of substrings without duplicate characters start with index i. If we do this for all i, we get our answer.

//Approach 3: Sliding Window Optimized
//The above solution requires at most 2n steps.
// In fact, it could be optimized to require only n steps.
// Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
// Then we can skip the characters immediately when we found a repeated character.
// The reason is that if s[j] have a duplicate in the range [i, j) with index j′, we don't need to increase i little by little.
// We can skip all the elements in the range [i,j′] and let i to be j′+1 directly.


public class MainClass
{
    public static void main(String[] args)
    {
        MainClass self = new MainClass();
        int result = self.lengthOfLongestSubstring("abcabcdbb");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s)
    {
        int length = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        for (int rightIndex = 0, leftIndex = 0; rightIndex < length; rightIndex++)
        {
            Character currentChar = s.charAt(rightIndex);
            if (map.containsKey(currentChar))
            {
                // 这里更新左索引。把左索引更新成这个字符上一次出现的位置的下一位。
                leftIndex = Math.max(map.get(currentChar), leftIndex);
            }
            // 字符串的长度是左右索引之差再+1。就好象从第1行到第10行，一共有10行，而不是10-1=9行
            ans = Math.max(ans, rightIndex - leftIndex + 1);
            // 这里更新map。如果这个字符在map里没有，就插入进去，如果有，就更新
            // 这里是rightIndex+1的原因，看上面的算法描述
            map.put(currentChar, rightIndex + 1);
        }
        return ans;
    }
}
