package cn.zzu.hot100_part3;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/10/21 9:22 上午
 */
public class Leetcode238_除自身以外数组的乘积 {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     * <p>
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 进阶：
     * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //遍历两次  第一次算出数组每个位置的左边所有的乘积 第二次遍历再乘以得到每个数右边的乘积
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = 1;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = left;
            left = left * nums[i];
        }
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            //更新右边的乘积
            right = right * nums[i];
        }
        return res;
    }
}
