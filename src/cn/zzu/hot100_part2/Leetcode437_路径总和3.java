package cn.zzu.hot100_part2;

import cn.zzu.hot100_part1.Leetcode617_合并二叉树.TreeNode;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/23 9:42 下午
 */
public class Leetcode437_路径总和3 {
    /**
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     * <p>
     * 找出路径和等于给定数值的路径总数。
     * <p>
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     * <p>
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     * <p>
     * 示例：
     * <p>
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     * <p>
     * 10
     * /  \
     * 5   -3
     * / \    \
     * 3   2   11
     * / \   \
     * 3  -2   1
     * <p>
     * 返回 3。和等于 8 的路径有:
     * <p>
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     */
    int res;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return res;
    }

    public void Sum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            res++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
