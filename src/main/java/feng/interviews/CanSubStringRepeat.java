package feng.interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个字符串是否由它的一个连续子串重复组成，比如"abab"可以表示成"ab"的重复，如果可以返回该子串，否则返回空字符串
 */
public class CanSubStringRepeat {

    public static void main(String[] args) {
        System.out.println(solution(null).isEmpty());
        System.out.println(solution("").isEmpty());
        System.out.println(solution("a").isEmpty());
        System.out.println(solution("aaa").equals("a"));
        System.out.println(solution("aba").isEmpty());
        System.out.println(solution("abab").equals("ab"));
        System.out.println(solution("abcab").isEmpty());
        System.out.println(solution("abcabcabc").equals("abc"));
        System.out.println(solution("abcabcabcabc").equals("abc"));
    }

    public static String solution(String str) {
        if (str == null || str.isEmpty() || str.length() == 1) {
            return "";
        }
        List<Integer> possibleSubLength = new ArrayList<>();
        for (int i = 1; i <= str.length() / 2; i++) {
            if (str.length() % i == 0) {
                possibleSubLength.add(i);
            }
        }
        Integer target = null;
        for (int subLength : possibleSubLength) {
            int repeatTimes = str.length() / subLength;
            boolean success = true;
            for (int i = 0; i < subLength; i++) {
                for (int k = 0; k < repeatTimes; k++) {
                    if (str.charAt(i) != str.charAt(i + k * subLength)) {
                        success = false;
                        break;
                    }
                }
                if (!success) {
                    break;
                }
            }
            if (success) {
                target = subLength;
                break;
            }
        }

        return target == null ? "" : str.substring(0, target);
    }
}