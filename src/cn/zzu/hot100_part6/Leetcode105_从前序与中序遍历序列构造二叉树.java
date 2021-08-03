package cn.zzu.hot100_part6;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/1/26 19:22
 */
public class Leetcode105_从前序与中序遍历序列构造二叉树 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
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

        //前序是  根左右    中序是左根右
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildHelp(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode buildHelp(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
            //递归退出条件
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            //preStart此处为根
            TreeNode root = new TreeNode(preorder[preStart]);
            //然后分别去找左右子树的根
            for (int i = inStart; i <= inEnd; i++) {
                //找到根在中序数组中的位置
                if (root.val == inorder[i]) {
                    //递归去找左右子树  返回左右子树的根   i-inStart代表从中序数组中 找到的左边孩子的个数  preStart+(i-inStart)就是先序中左孩子的终点位置
                    root.left = buildHelp(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                    root.right = buildHelp(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
                    break;
                }
            }
            return root;
        }
    }
}
