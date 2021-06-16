package cn.zzu.hot100_part1;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/13 12:16 下午
 */
public class Leetcode739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else if (j == T.length - 1) {
                    res[i] = 0;
                }
            }
        }

        return res;
    }

    /**
     * 用栈保存数组下标（维持一个递减的栈），每次弹出下标  找到第一个比该下标对应元素大的位置
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Arrays.fill(res, 0);
        Stack<Integer> stack = new Stack<>();
        for (int cur = 0; cur < T.length; cur++) {
            //栈不为空 并且当前值大于栈顶  循环去找
            while (!stack.isEmpty()&&T[cur]>T[stack.peek()]){
                int before=stack.pop();
                res[before]=cur-before;
            }
            //当前位置入栈
            stack.push(cur);
        }
        return res;
    }
}
