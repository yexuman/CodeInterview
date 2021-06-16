package cn.zzu;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/8 下午8:24
 */
public class Leetcode153_旋转数组的最小值 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     *
     * 示例 1:
     *
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     * ————————————————
     * 版权声明：本文为CSDN博主「Coding Now」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_41864967/article/details/84891912
     */

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left=0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left]<nums[right])
                return nums[left];
            int mid = left + (right-left)/2;
            //前半段递增
            if(nums[mid]>=nums[left]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
