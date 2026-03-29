package feng.interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出只出现一次的值
 */
public class FindAppearOnce
{
    /**
     * 找出数组中只出现一次的值
     *
     * @param nums 要查找的数组，其中有一个值只出现了一次，其他值出现次数大于1
     * @return 只出现一次的值
     * @throws IllegalArgumentException 如果数组为null或空数组，或者没有只出现一次的值
     */
    public static int findAppearOnce(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            throw new IllegalArgumentException("array null or empty");
        }

        // 出现次数的map，数组中的数值，value是该值出现的次数
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int num : nums)
        {
            if (!timesMap.containsKey(num) || timesMap.get(num) == null)
            {
                timesMap.put(num, 1);
            }
            else
            {
                timesMap.put(num, timesMap.get(num) + 1);
            }
        }
        if (timesMap.values().stream().filter(v -> v.equals(1)).count() != 1)
        {
            throw new IllegalArgumentException("no value or multiple value appeared once");
        }
        return timesMap.entrySet().stream().filter(timesEntry -> timesEntry.getValue() == 1).map(Map.Entry::getKey)
                .findFirst().orElseThrow(IllegalStateException::new);
    }
}
