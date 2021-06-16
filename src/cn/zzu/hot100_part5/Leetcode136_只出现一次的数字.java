package cn.zzu.hot100_part5;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/12/23 18:40
 */
public class Leetcode136_只出现一次的数字 {

    public int singleNumber(int[] nums) {
        if (nums == null)
            return 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = nums[i] ^ res;
        }
        return res;
    }
}

