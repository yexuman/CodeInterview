package cn.zzu.hot100_part5;

import cn.zzu.hot100_part1.Leetcode617_合并二叉树.TreeNode ;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/1/8 11:05
 */
public class Leetcode124_二叉树中的最大路径和 {
    /**
     * 给定一个非空二叉树，返回其最大路径和。
     *
     * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出：6
     * 示例 2：
     *
     * 输入：[-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出：42
     *
     */
    // 该函数返回是左右的最大路径和，而非左+右+root的最大值
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        processLeftRight(root);
        System.out.println(res);
        return res;

    }

    // 该函数返回是左右的最大路径和，而非左+右+root的最大值
    public int processLeftRight(TreeNode root) {
        if (root == null) {
            return 0; // 为叶子 也是递归退出条件
        }
        int leftMax = Math.max(0, processLeftRight(root.left));
        int rightMax = Math.max(0, processLeftRight(root.right));

        res = Math.max(res, root.val + leftMax + rightMax); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(leftMax, rightMax) + root.val;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-10);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        Leetcode124_二叉树中的最大路径和 test = new Leetcode124_二叉树中的最大路径和();
        test.maxPathSum(t1);

    }
}
