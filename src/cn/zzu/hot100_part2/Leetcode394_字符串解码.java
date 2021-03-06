package cn.zzu.hot100_part2;

import java.util.Stack;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/26 4:54 下午
 */
public class Leetcode394_字符串解码 {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     */

    public String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> resStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                resStack.add(res);
                multiStack.add(multi);
                res = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                res.append(c);
            } else {
                StringBuffer ansTmp = resStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    ansTmp.append(res);
                }
                res = ansTmp;
            }
        }
        return res.toString();
    }
}
