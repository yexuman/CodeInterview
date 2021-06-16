package cn.classify;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/15 上午10:32
 */
public class Leetcode45_跳跃游戏2 {
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0; // 上次跳跃可达范围右边界（下次的最右起跳点）
        int maxPosition = 0; // 目前能跳到的最远位置
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end) {
                end = maxPosition; // 目前能跳到的最远位置变成了下次起跳位置的有边界
                steps++;  // 进入下一次跳跃

            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,2,3};
        jump(arr);
    }
}
