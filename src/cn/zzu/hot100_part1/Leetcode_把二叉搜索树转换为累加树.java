package cn.zzu.hot100_part1;

import cn.zzu.hot100_part1.Leetcode617_合并二叉树.TreeNode;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/18 1:10 下午
 */
public class Leetcode_把二叉搜索树转换为累加树 {
    /**
     * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     * <p>
     *  
     * <p>
     * 例如：
     * <p>
     * 输入: 原始二叉搜索树:
     * 5
     * /   \
     * 2     13
     * <p>
     * 输出: 转换为累加树:
     * 18
     * /   \
     * 20     13
     *
     * @param root
     * @return
     */


    /**
     * 一个高效的解法应该遍历每个节点一次。解法的关键在于应该按照节点值降序遍历所有节点，
     * 同时记录我们已经遍历过的节点值的和，并把这个和加到当前节点的值中。这种遍历树的方法被称作 反序中序遍历
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //遍历右子树
        convertBST(root.right);
        //遍历顶点
        root.val = root.val + sum;
        sum = root.val;
        //遍历左子树
        convertBST(root.left);
        return root;

    }
}
