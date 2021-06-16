package cn.zzu;

import java.util.Stack;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/8 下午11:02
 */
public class Leetcode84_条形图的最大面积 {
    public static int getMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.isEmpty() && stack.peek() >= heights[i]) {  //栈非空且当前值比栈顶大
                int count = 0;
                while (!stack.isEmpty() && stack.peek() > heights[i]) {
                    count++;
                    int h = stack.pop();
                    max = Math.max(max, h * count);
                }
                // 用当前高度补齐之前弹出的
                while (count != 0) {
                    stack.push(heights[i]);
                    count--;
                }
            }
            stack.push(heights[i]); // 当前高度入栈
        }
        //和栈中的最大面积比大小
        int count=0;
        while (!stack.isEmpty()) {
            count++;
            max=Math.max(max, stack.peek()*count);
            stack.pop();
        }
        return max;
    }
}
