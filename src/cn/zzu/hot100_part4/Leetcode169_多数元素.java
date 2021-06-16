package cn.zzu.hot100_part4;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/11/25 15:23
 */
public class Leetcode169_多数元素 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int majorityElement(int[] nums) {
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (res == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i + 1];
                }
            }

        }
        return res;
    }
}
