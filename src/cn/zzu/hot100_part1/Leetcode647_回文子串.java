package cn.zzu.hot100_part1;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/13 1:20 下午
 */
public class Leetcode647_回文子串 {
    /**
     * 中心拓展法，调用count函数是计算以i或（i,i+1)为中心的回文串个数
     */
    int num = 0;
    public int countSubstrings(String s) {
        for (int i=0; i < s.length(); i++){
            count(s, i, i);//回文串长度为奇数
            count(s, i, i+1);//回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            num++;
            start--;
            end++;
        }
    }
}
