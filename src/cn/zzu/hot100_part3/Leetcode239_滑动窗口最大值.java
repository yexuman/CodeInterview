package cn.zzu.hot100_part3;

import java.util.LinkedList;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/10/19 12:37 下午
 */
public class Leetcode239_滑动窗口最大值 {
    /**
     * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *  
     *
     * 进阶：
     *
     * 你能在线性时间复杂度内解决此题吗？
     *
     *  
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     * 通过次数81,897提交次数166,472
     *
     *
     */
    public static  int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        LinkedList<Integer> queue = new LinkedList<>();  //存放递减的元素的下标
        for(int i = 0; i < nums.length; i++) {
            if(!queue.isEmpty()){
                // 如果队列头元素不在滑动窗口中了，就删除头元素
                if(i >= queue.peek() + k) {
                    queue.pop();
                }
                // 如果当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列空
                while(!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                    queue.removeLast();
                }
            }
            queue.offer(i); // 入队列
            // 滑动窗口经过三个元素，获取当前的最大值，也就是队列的头元素
            if(i + 1 >= k) {
                res[i-k+1]=nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
         int[]  arr=new int[]{1,3,-1,-3,5,3,6,7} ;
        maxSlidingWindow(arr,3);
    }
}
