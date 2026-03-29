package feng.interviews;

/**
 * 旋转数组查找
 */
public class FindNum
{
    /**
     * 旋转数组查找
     *
     * @param nums   被旋转后的数组
     * @param target 目标值
     * @return 目标值的下标，如果不存在返回-1
     */
    public static int findNum(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        return findNum(nums, 0, nums.length - 1, target);
    }

    /**
     * 旋转数组查找
     *
     * @param nums   被旋转后的数组
     * @param from   起始位置，包含
     * @param to     结束位置，包含
     * @param target 目标值
     * @return 目标值的下标，如果不存在返回-1
     */
    public static int findNum(int[] nums, int from, int to, int target)
    {
        if (nums == null || nums.length == 0 || from > to || from < 0 || to >= nums.length)
        {
            return -1;
        }
        int fromVal = nums[from];
        if (from == to)
        {
            return fromVal == target ? from : -1;
        }
        if (fromVal == target)
        {
            return from;
        }
        int toVal = nums[to];
        if (toVal == target)
        {
            return to;
        }
        if (to - from == 1)
        {
            return -1;
        }

        int middleIndex = from + (to - from) / 2;
        int middleVal = nums[middleIndex];
        if (middleVal == target)
        {
            return middleIndex;
        }

        boolean isTurnPoint = middleVal > nums[middleIndex + 1];
        if (isTurnPoint)
        {
            if (middleVal < target)
            {
                return -1;  // 在转折点，那middleVal就是最大值，如果最大值比target还小，那target在数组里不存在
            }
            else if (nums[middleIndex + 1] > target)
            {
                return -1;  // 在转折点，那middleIndex右侧就是最小值，如果最小值比target都大，那target在数组里不存在
            }
            else if (fromVal > target)
            {
                // 第一个元素是较大一边的最小值，如果它比target大，那target只可能在右边
                return ascBinSearch(nums, middleIndex + 1, to - 1, target);
            }
            else
            {
                return ascBinSearch(nums, from + 1, middleIndex - 1, target);
            }
        }
        else
        {
            boolean isMiddleInBiggerSide = middleVal > nums[0];  // 第一个元素是较大一边的最小值，同时比较小一边的任何值都大，所以如果middleVal比第一个元素还大，说明middleIndex在较大一边
            if (isMiddleInBiggerSide && middleVal > target)
            {  // middleIndex在较大一边，且middleVal比target大
                if (fromVal > target)
                {  // 第一个元素是较大一边的最小值，它比target大，那target只能右边
                    return findNum(nums, middleIndex + 1, to - 1, target);
                }
                else
                {  // target比middleVal小但比第一个元素大，那它只能在左边
                    return findNum(nums, from + 1, middleIndex - 1, target);
                }
            }
            else if (isMiddleInBiggerSide)
            {   // middleIndex在较大一边，且middleVal比target小，那target只能右边
                return findNum(nums, middleIndex + 1, to - 1, target);
            }
            else if (middleVal > target)
            {  // middleIndex在较小一边，且middleVal比target大，那target只能在左边
                return findNum(nums, from + 1, middleIndex - 1, target);
            }
            else
            {  // middleIndex在较小一边，且middleVal比target小，那target只能在右边
                return findNum(nums, middleIndex + 1, to - 1, target);
            }
        }
    }

    /**
     * 升序数组的二分查找
     *
     * @param nums   要查找的数组，必须是升序且不能有重复元素
     * @param from   起始位置，包含
     * @param to     结束位置，包含
     * @param target 要查找的目标值
     * @return 目标值的下标，如果不存在返回-1
     */
    public static int ascBinSearch(int[] nums, int from, int to, int target)
    {
        if (nums == null || nums.length == 0 || from > to)
        {
            return -1;
        }
        from = Math.max(from, 0);
        to = Math.min(to, nums.length - 1);
        while (from <= to)
        {
            int fromVal = nums[from];
            if (from == to)
            {
                return fromVal == target ? from : -1;
            }
            if (fromVal == target)
            {
                return from;
            }
            if (fromVal > target)
            {
                return -1;
            }
            int toVal = nums[to];
            if (toVal == target)
            {
                return to;
            }
            if (toVal < target)
            {
                return -1;
            }
            if (to - from == 1)
            {
                return -1;
            }
            int middleIndex = from + (to - from) / 2;
            int middleVal = nums[middleIndex];
            if (middleVal == target)
            {
                return middleIndex;
            }
            if (middleVal > target)
            {
                to = middleIndex;
            }
            else
            {
                from = middleIndex;
            }
        }
        return -1;
    }
}
