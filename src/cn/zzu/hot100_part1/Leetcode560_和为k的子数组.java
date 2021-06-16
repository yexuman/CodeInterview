package cn.zzu.hot100_part1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/16 9:39 上午
 */
public class Leetcode560_和为k的子数组 {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * <p>
     * 示例 1 :
     * <p>
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     * <p>
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     */
    //map 存放和sum   以及出现的次数
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums == null)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        //设置默认值  和为0的  默认为1次
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
