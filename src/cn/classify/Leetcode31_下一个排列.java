package cn.classify;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/14 下午4:55
 */
public class Leetcode31_下一个排列 {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     *
     * ————————————————
     * 版权声明：本文为CSDN博主「Coding Now」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_41864967/article/details/89979244
     */

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length-2;
        //找到第一个非递增的位置
        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        //说明一开始不是最大的排列
        if (i>=0){
            int j = i+1;
            //找到大于i位置的最小值  由于i+1后部分是降序的  所以找最远的
            while (j<nums.length && nums[j] > nums[i]){
                j++;
            }
            //退出循环时 j位置的值已经小于或者等于i了
            //将i位置和找到的大于i位置的最小值交换
            swapNums(nums,i,j-1);
        }
        //若一开始就是最大的排列  也就是全部递减的这种  54321
        i++;
        int end = nums.length-1;
        while (i<=end){
            swapNums(nums, i++, end--);
        }
    }

    private void swapNums(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
