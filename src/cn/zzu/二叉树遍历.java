package cn.zzu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/22 下午4:03
 */
public class 二叉树遍历 {
    public class TreeNode {
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

    //前序递归
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    //前序非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            if (curNode.left != null) {
                stack.add(curNode.left);
            }
        }
        return res;
    }

    //中序非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                //左孩子到头了  弹出来
                TreeNode curNode = stack.pop();
                res.add(curNode.val);
                root = curNode.right;
            }
        }
        return res;
    }
}
