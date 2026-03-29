package feng.interviews;

public class StringNumAdd
{
    public static String stringNumAdd(String str1,String str2)
    {
        if (str1 == null || str1.isEmpty() || str1.equals("0"))
        {
            return str2;
        }
        if (str2 == null || str2.isEmpty() || str2.equals("0"))
        {
            return str1;
        }

        String longerNumber = str1.length() > str2.length() ? str1 : str2;
        String shorterNumber = str1.length() > str2.length() ? str2 : str1;
        int lengthDiff = longerNumber.length() - shorterNumber.length();

        char[] result = new char[longerNumber.length() + 1];
        SimpleAdd lastResult = new SimpleAdd();
        int currentPos = result.length - 1;
        for (int i = longerNumber.length() - 1; i >= 0; i--,currentPos--)
        {
            int shorterNumberIndex = i - lengthDiff;
            if (shorterNumberIndex >= 0)
            {
                lastResult.update(longerNumber.charAt(i) + shorterNumber.charAt(shorterNumberIndex) - 96);
            }
            else
            {
                lastResult.update(longerNumber.charAt(i) - 48);
            }
            result[currentPos] = (char)(lastResult.ones + 48);
        }
        if (lastResult.tens == 1)
        {
            result[0] = '1';
        }

        return ((int)result[0] == 0) ? new String(result,1,result.length - 1) : new String(result);
    }

    private static class SimpleAdd
    {
        private int ones = 0;
        private int tens = 0;

        public void update(int toAdd)
        {
            int temp = toAdd + tens;
            if (temp < 10)
            {
                ones = temp;
                tens = 0;
            }
            else
            {
                ones = temp - 10;
                tens = 1;
            }
        }
    }
}
