package cn.zzu.hot100_part2;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/30 1:07 下午
 */
public class Leetcode322_零钱兑换 {
    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：coins = [1], amount = 1
     * 输出：1
     * 示例 5：
     * <p>
     * 输入：coins = [1], amount = 2
     * 输出：2
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 231 - 1
     */

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }

                }
            }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
