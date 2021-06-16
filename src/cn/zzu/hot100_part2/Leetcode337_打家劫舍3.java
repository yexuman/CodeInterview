package cn.zzu.hot100_part2;

import cn.zzu.hot100_part1.Leetcode617_合并二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/29 6:38 下午
 */
public class Leetcode337_打家劫舍3 {
    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     *      3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     */
    //要根节点和不要根节点情况


    //使用map保存已计算的答案
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int left = rob(root.left);
        int right = rob(root.right);
        int includeRoot = root.val;
        if (root.left != null) {
            includeRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            includeRoot += rob(root.right.left) + rob(root.right.right);
        }
        int notIncludeRoot = left + right;
        map.put(root, Math.max(includeRoot, notIncludeRoot));
        return Math.max(includeRoot, notIncludeRoot);
    }
}
