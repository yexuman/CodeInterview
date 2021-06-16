package cn.zzu;
import java.util.*;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/1 下午3:22
 */
public class Leetcode3_无重复的最长子串 {


        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max = 0;
            int left = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    //防止left往左走   比如abba   走到第二个a时
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                max = Math.max(max, i - left + 1);
            }
            return max;
        }

}
