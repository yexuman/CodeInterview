package cn.classify.before;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/3/21 17:28
 */
public class 多数元素 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[3,2,3]
     * 输出：3
     * 示例 2：
     *
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xm77tm/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int majorityElement(int[] nums) {
        if (nums==null){
            return 0;
        }
        int most = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (most == nums[i]){
                count++;
            }else {
                count--;
                if (count==0){
                    most = nums[i];
                    count = 1;
                }
            }
        }
        return most;
    }
}
