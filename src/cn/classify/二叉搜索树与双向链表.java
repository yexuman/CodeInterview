package cn.classify;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/5/25 下午5:56
 */
public class 二叉搜索树与双向链表 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
    private TreeNode pre=null;
    private TreeNode head=null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    /**
     * 中序遍历的时候指定链表的关系
     * @param cur
     */
    private void inOrder(TreeNode cur) {
        if(cur==null){
            return;
        }
        inOrder(cur.left);
        cur.left=pre;
        if (pre!=null){
            pre.right=cur;
        }
        //pre来到下一个节点
        pre = cur;
        //将会把最左边的孩子节点赋值给head
        if (head==null){
            head = cur;
        }
        inOrder(cur.right);
    }
}
