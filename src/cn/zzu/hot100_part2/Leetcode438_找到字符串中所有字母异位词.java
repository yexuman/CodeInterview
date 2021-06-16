package cn.zzu.hot100_part2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/22 10:33 上午
 */
public class Leetcode438_找到字符串中所有字母异位词 {
    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * <p>
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     * <p>
     * 说明：
     * <p>
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     * <p>
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * <p>
     * 输出:
     * [0, 6]
     * <p>
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     * <p>
     * 输入:
     * s: "abab" p: "ab"
     * <p>
     * 输出:
     * [0, 1, 2]
     * <p>
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     */
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> smap = new HashMap<>(); //记录s的每个字符和出现的次数
        Map<Character, Integer> pmap = new HashMap<>(); //记录p的每个字符和出现的次数
        for (char ch : p.toCharArray()) {
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int count = 0; //候选字符的个数
        int len = p.length();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            //如果 p 中包含当前字符，且s的窗口中该字符出现次数不足，则该字符可以作为候选字符，count加一
            if (pmap.containsKey(ch) && smap.get(ch) <= pmap.get(ch)) {
                count++;
            }
            //当候选字符个数等于p长度，此时left为起始索引
            if (count == len) {
                res.add(left);
            }
            //当窗口大小等于p长度时，窗口左边需要收缩一个字符
            if (right - left + 1 >= len) {
                char leftChar = s.charAt(left);
                //判断收缩的这个字符是否是候选字符，是则count减一
                if (pmap.containsKey(leftChar) && smap.get(leftChar) <= pmap.get(leftChar)) {
                    count--;
                }
                //窗口收缩一个字符
                smap.put(leftChar, smap.getOrDefault(leftChar, 1) - 1);
                left++;
            }
            right++;
        }
        return res;
    }
}

