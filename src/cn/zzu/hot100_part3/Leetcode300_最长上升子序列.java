package cn.zzu.hot100_part3;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/10/10 3:50 下午
 */
public class Leetcode300_最长上升子序列 {

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * <p>
     * 示例:
     * <p>
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * 说明:
     * <p>
     * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
     * 你算法的时间复杂度应该为 O(n2) 。
     * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            //相当于初始化 =1 代表本身就是最长子序列
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //如果当前i位置值  比 之前j位置值大  更新一下dp[i]
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //在遍历过程中更新最大子序列长度res
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
