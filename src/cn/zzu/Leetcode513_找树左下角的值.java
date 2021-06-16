package cn.zzu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/10 下午7:36
 */
public class Leetcode513_找树左下角的值 {
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

    /**
     * 层序
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (i == 0) {
                    //每一行的第一个值  进行覆盖
                    res = curNode.val;
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
        }
        return res;
    }


    /**
     * 深度优先遍历  拿到每一行最左边的  （深度刚开始加1的时候  就是最左边的第一个）
     */
    int result = Integer.MIN_VALUE;
    int maxDepth = 0;

    public int findBottomLeftValue2(TreeNode root) {
        help(root, 1);
        return result;
    }

    private void help(TreeNode root, int curDepth) {
        if (root == null)
            return;
        if (maxDepth < curDepth) {
            //每一行的第一个值  进行覆盖
            maxDepth = curDepth;
            result = root.val;
        }
        help(root.left, curDepth + 1);
        help(root.right, curDepth + 1);
    }


    /**
     * 同理解法  二叉树的右视图
     */
    List<Integer> res = new ArrayList<>();
    int mDepth = 0;
    public List<Integer> rightSideView2(TreeNode root) {
        help2(root, 1);
        return res;
    }

    private void help2(TreeNode root, int curDepth) {
        if (root == null)
            return;
        if (curDepth>mDepth){
            res.add(root.val);
            mDepth = curDepth;
        }
        help2(root.right, curDepth+1);
        help2(root.left, curDepth+1);
    }
}
