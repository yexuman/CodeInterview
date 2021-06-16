package cn.zzu.hot100_part3;

import java.util.Arrays;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/10/12 8:43 下午
 */
public class Leetcode279_完全平方数 {
    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     *
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     * 示例 2:
     *
     * 输入: n = 13
     * 输出: 2
     * 解释: 13 = 4 + 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int numSquares(int n) {
        //dp[i]表示组成数字i时的最少完全平方数的个数
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //base case
        dp[0] = 0;
        //初始化
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

}
