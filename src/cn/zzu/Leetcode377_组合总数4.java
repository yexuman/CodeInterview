package cn.zzu;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/11 下午8:32
 */
public class Leetcode377_组合总数4 {
    /**
     * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
     * <p>
     * 示例:
     * <p>
     * nums = [1, 2, 3]
     * target = 4
     * <p>
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * <p>
     * 请注意，顺序不同的序列被视作不同的组合。
     * <p>
     * 因此输出为 7。
     * <p>
     * ————————————————
     * 版权声明：本文为CSDN博主「Coding Now」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_41864967/article/details/88314491
     */
    //dp[i][j]表示从数组0-位置得到和为j的种数
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int j = 0; j <= target; j++) {
            if (j % nums[0] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
//                dp[i][j] = dp[i - 1][j];
                int k = 0;
                //可以用多次
                while (j >= k * nums[i]) {
                    dp[i][j] += dp[i - 1][j - k * nums[i]];
                    k++;
                }
            }
        }
        return dp[n - 1][target];
    }
}
