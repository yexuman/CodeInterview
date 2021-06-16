package cn.zzu.hot100_part1;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/18 8:13 下午
 */
public class Leetcode494_目标和 {

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：nums: [1, 1, 1, 1, 1], S: 3
     * 输出：5
     * 解释：
     * <p>
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * <p>
     * 一共有5种方法让最终目标和为3。
     */

    //没有问题
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }
        int realTarget = (sum + target) / 2;
        int[] dp = new int[realTarget + 1];

        dp[0] = 1;
        // 在每一个位置都可以选择是否要当前位置的数
        for (int i = 0; i < nums.length; i++) { // 从1位置开始
            for (int j = realTarget; j >= nums[i]; j--) {
                // 要当前值nums[i] 和 不要当前值nums[i]
                dp[j] = dp[j] + dp[j - nums[i]];

            }
        }
        return dp[realTarget];
    }

    //有问题
    public static int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum < target || (sum + target) % 2 != 0) {
            return 0;
        }
        int realTarget = (target + sum) / 2;
        // 寻找和为target的种数
        int[][] dp = new int[nums.length][realTarget + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < realTarget+1; j++) {
            if (nums[0] == j) {
                dp[0][j] = 1;
            }
        }
        // 在每一个位置都可以选择是否要当前位置的数
        for (int i = 1; i < nums.length; i++) { // 从1位置开始
            for (int j = 1; j <= realTarget; j++) {
                // 要当前值nums[i] 和 不要当前值nums[i]
                dp[i][j] = dp[i - 1][j] ;
                if (j>=nums[i]){
                    dp[i][j] += dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length - 1][realTarget];
    }

}
