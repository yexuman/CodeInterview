package cn.zzu.hot100_part6;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/1/16 14:18
 */
public class Leetcode114_二叉树展开为链表 {
    /**
     * 给定一个二叉树，原地将它展开为一个单链表。
     * <p>
     *  
     * <p>
     * 例如，给定二叉树
     * <p>
     * 1
     * / \
     * 2   5
     * / \   \
     * 3   4   6
     * 将其展开为：
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * 5
     * \
     * 6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

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

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        //1、将当前节点的右节点保存起来
        TreeNode tmp = root.right;
        //2、当前节点的左孩子 赋值给右孩子
        root.right = root.left;
        root.left = null;
        //3、将第2步得到的右节点 往右下沉 直到它不再有右孩子
        while (root.right != null)
            root = root.right;
        //4、将第3步得到的右孩子  的右孩子节点赋值为之前保存的左孩子节点
        root.right = tmp;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n2.left = n3;
        n2.right = n4;
        n1.right = n5;
        n5.right = n6;
        flatten(n1);
        while (n1 != null) {
            System.out.println(n1.val);
            n1 = n1.right;
        }
    }
}
