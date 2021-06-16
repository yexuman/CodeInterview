package cn.zzu.hot100_part5;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/12/1 10:57
 */
public class Leetcode152_乘积最大子数组 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProduct(int[] nums) {
        if (nums == null)
            return 0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            } else if (nums[i] < 0) {
                //暂存一下
                int temp = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * temp);
            } else {
                max = 0;
                min = 0;
            }
            res = Math.max(res, max);
        }
        return res;
    }

    //以当前元素结尾的乘积最大子数组的乘积
    public int maxProduct2(int[] nums) {
        if (nums == null)
            return 0;
        int res = nums[0];
        //以当前元素结尾的最大乘积
        int[] max = new int[nums.length];
        //以当前元素结尾的最小乘积
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                int temp = max[i - 1];  //保存一下
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }

    //类似的题目  最大子序和

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums==null)
            return 0;
        //以当前位置为结尾的最大子数组和
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum[i-1] >=0){
                sum[i] = sum[i-1] + nums[i];
            }else {
                sum[i] = nums[i];
            }
            res= Math.max(res,sum[i]);
        }
        return res;
    }
}
