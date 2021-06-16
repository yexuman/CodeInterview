package cn.zzu.hot100_part1;

import cn.zzu.hot100_part1.Leetcode617_合并二叉树.TreeNode;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/17 12:06 上午
 */
public class Leetcode543_二叉树的直径 {

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * <p>
     *  
     * <p>
     * 示例 :
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     */


    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        res = Math.max(Left + Right, res);//将每个节点最大直径,不是节点个数(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1;//返回树深度
    }

}
