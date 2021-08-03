package cn.zzu;

import cn.zzu.hot100_part6.Leetcode105_从前序与中序遍历序列构造二叉树;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/7/19 下午5:07
 */
public class 二叉搜索树第k小的节点 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int res = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);
    }
}
