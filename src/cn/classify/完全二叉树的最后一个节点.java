package cn.classify;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/3/31 11:21
 */
public class 完全二叉树的最后一个节点 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }


    public static TreeNode getLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (i == size - 1) {
                    res = cur;
                }
            }
        }
        return res;
    }

    public static TreeNode getLastNode2(TreeNode root) {
        if (root != null || root.left==null) {
            return root;
        }
        int leftHeight = 1;
        int rightHeight = 1;
        TreeNode lNode = root.left;
        TreeNode rNode = root.right;

        while (lNode != null) {
            leftHeight++;
            lNode = lNode.left;
        }
        while (rNode != null) {
            rightHeight++;
            rNode = rNode.left;
        }
        if (leftHeight>rightHeight){
            return getLastNode2(root.left);
        }else {
            return getLastNode2(root.right);
        }
    }
}
