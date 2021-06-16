package cn.zzu.hot100_part2;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/24 1:28 下午
 */
public class Leetcode416_分割等和子集 {

    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * 注意:
     * <p>
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     * <p>
     * 输入: [1, 5, 11, 5]
     * <p>
     * 输出: true
     * <p>
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *  
     * <p>
     * 示例 2:
     * <p>
     * 输入: [1, 2, 3, 5]
     * <p>
     * 输出: false
     * <p>
     * 解释: 数组不能分割成两个元素和相等的子集.
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;//整数相加不可能得小数
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < target + 1; ++j) {
                if (i == 0) {
                    if (nums[i] == j) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] || (j >= nums[i] && dp[i - 1][j - nums[i]]);
                }
            }

        }
        return dp[nums.length - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;//整数相加不可能得小数
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 要当前值nums[i] 和 不要当前值nums[i]
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
