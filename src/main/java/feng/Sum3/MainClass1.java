package feng.Sum3;

import java.util.ArrayList;
import java.util.List;

// 太慢了，会出Time Limit Exceeded
public class MainClass1
{
    public static void main(String[] args)
    {
        MainClass1 self = new MainClass1();
        int[] array = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        System.out.println(self.threeSum(array));
    }

    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i < nums.length;i++)
        {
            for (int j = i + 1;j < nums.length;j++)
            {
                int currentA = nums[i];
                int currentB = nums[j];
                if (ifAlreadyExamed(currentA,currentB,result))
                {
                    continue;
                }
                int targetC = -1 * (currentA + currentB);
                if ( -1 != ifCExists(nums,i,j,targetC))
                {
                    List<Integer> currentArray = new ArrayList<>();
                    currentArray.add(currentA);
                    currentArray.add(currentB);
                    currentArray.add(targetC);
                    result.add(currentArray);
                }
            }
        }
        return result;
    }

    public boolean ifAlreadyExamed(int a,int b,List<List<Integer>> currentReslt)
    {
        boolean result = false;
        for(int i = 0;i < currentReslt.size();i++)
        {
            List<Integer> currentArray = currentReslt.get(i);
            boolean ifAInArray = false;
            boolean ifBInArray = false;
            for (int j = 0;j <= 2;j++)
            {
                // 如果这样写，当a和b都是0，且现有方案中有一个方案包含1个0，就会判断出错
//                if (a == currentArray.get(j))
//                {
//                    ifAInArray = true;
//                }
//                if (b == currentArray.get(j))
//                {
//                    ifBInArray = true;
//                }
                if (a == currentArray.get(j) && !ifAInArray)
                {
                    ifAInArray = true;
                }
                else if (b == currentArray.get(j) && !ifBInArray)
                {
                    ifBInArray = true;
                }
            }
            if (ifAInArray && ifBInArray)
            {
                result = true;
                break;
            }
        }
        return result;
    }

    public int ifCExists(int[] nums,int indexA,int indexB,int targetC)
    {
        int result = -1;
        for (int i = 0;i < nums.length;i++)
        {
            if (i == indexA || i == indexB)
            {
                continue;
            }
            if (nums[i] == targetC)
            {
                result = i;
                break;
            }
        }
        return result;
    }
}
