package cn.classify;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/12 下午9:18
 */
public class Leetcode718_最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[][] dp = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {  //相等情况
                    if (i != 0 && j != 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        res = Math.max(res, dp[i][j]);
                    } else {    //i和j至少有一个为0
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return res;
    }
}
