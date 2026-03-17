package feng.StringToInteger_atoi;

import java.util.*;

public class MainClass
{
    public static void main(String[] args)
    {
        MainClass self = new MainClass();
        System.out.println(self.myAtoi("   +0 123"));
    }

    public int myAtoi(String str)
    {
        Map<Character,Integer> charToInt = new HashMap<>();
        charToInt.put('0',0);
        charToInt.put('1',1);
        charToInt.put('2',2);
        charToInt.put('3',3);
        charToInt.put('4',4);
        charToInt.put('5',5);
        charToInt.put('6',6);
        charToInt.put('7',7);
        charToInt.put('8',8);
        charToInt.put('9',9);

        List<Integer> resultList = new ArrayList<>();
        int negativeTag = 1;

        boolean firstUnWhiteFound = false;
        for (int i = 0;i <= str.length() -1;i++)
        {
            char currentChar = str.charAt(i);
            if (!firstUnWhiteFound)
            {
                if (' ' == currentChar)
                {
                    continue;
                }
                firstUnWhiteFound = true;
                if (charToInt.containsKey(currentChar) || '-' == currentChar || '+' == currentChar)
                {
                    if ('-' == currentChar)
                    {
                        negativeTag = -1;
                    }
                    else if ('0' != currentChar && '+' != currentChar)
                    {
                        resultList.add(charToInt.get(currentChar));
                    }
                }
                else
                {
                    // 第一个非空白字符不是数字或符号
                    return 0;
                }
            }
            else if (charToInt.containsKey(currentChar))
            {
                resultList.add(charToInt.get(currentChar));
            }
            else
            {
                break;
            }
        }

        double result = 0;
        double k = 0.0;
        for (int i = resultList.size() - 1;i >= 0;i--)
        {
            result = result + negativeTag * resultList.get(i) * Math.pow(10.0,k);
            k = k + 1;
            if (result > Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }
        }
        return (int)result;
    }
}
