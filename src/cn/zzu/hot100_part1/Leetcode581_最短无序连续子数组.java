package cn.zzu.hot100_part1;

import java.util.Arrays;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/15 6:13 下午
 */
public class Leetcode581_最短无序连续子数组 {
    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * <p>
     * 你找到的子数组应是最短的，请输出它的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     * <p>
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     */

    public int findUnsortedSubarray(int[] nums) {
        int[] copyArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copyArray[i] = nums[i];
        }
        Arrays.sort(nums);
        int start = -1;
        int end = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyArray[i]) {
                start = i;
                break;
            }
        }
        for (int j = nums.length-1; j >= 0; j--) {
            if (nums[j] != copyArray[j]) {
                end = j;
                break;
            }
        }
        return start!=-1? (end - start + 1):0;
    }
}
