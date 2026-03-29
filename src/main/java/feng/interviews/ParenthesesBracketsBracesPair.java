package feng.interviews;

import java.util.Stack;

/**
 * 识别括号是否成对
 */
public class ParenthesesBracketsBracesPair
{
    /**
     * 识别一个由大中小括号组成的字符串字符串中的括号是否成对
     *
     * @param str 要检查的字符串
     * @return 如果成对返回true，否则返回false，{@code str}为null或空字符串时为false
     * @throws IllegalArgumentException 如果{@code str} 中有非大中小括号的字符
     */
    public static boolean isPair(String str)
    {
        if (str == null || str.isEmpty())
        {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
        {
            char currentChar = str.charAt(i);
            if (currentChar != '(' && currentChar != ')' && currentChar != '[' && currentChar != ']' && currentChar != '{' && currentChar != '}')
            {
                throw new IllegalArgumentException("has other chars");
            }
            if (currentChar == '(' || currentChar == '[' || currentChar == '{')
            {
                stack.push(currentChar);
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                Character currentStackTop = stack.peek();
                if ((currentChar == ')' && currentStackTop.equals('('))
                        || (currentChar == ']' && currentStackTop.equals('['))
                        || (currentChar == '}' && currentStackTop.equals('{')))
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
