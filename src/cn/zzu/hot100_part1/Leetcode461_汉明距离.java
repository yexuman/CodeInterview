package cn.zzu.hot100_part1;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/20 8:10 下午
 */
public class Leetcode461_汉明距离 {

    /**
     * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
     * <p>
     * 给出两个整数 x 和 y，计算它们之间的汉明距离。
     * <p>
     * 注意：
     * 0 ≤ x, y < 231.
     * <p>
     * 示例:
     * <p>
     * 输入: x = 1, y = 4
     * <p>
     * 输出: 2
     * <p>
     * 解释:
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     * ↑   ↑
     * <p>
     * 上面的箭头指出了对应二进制位不同的位置。
     */
    public int hammingDistance(int x, int y) {
        //异或运算  相同得0  相反得1
        int num = x ^ y;
        int res = 0;
        while (num != 0) {
            int flag = num & 1;
            if (flag==1){
                res ++;
            }
            num = num >> 1;
        }
        return res;
    }
}
