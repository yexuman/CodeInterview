package cn.zzu;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/11 下午5:23
 */
public class Leetcode547_好友圈数量 {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        int res = 0;
        boolean[] hasVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!hasVisited[i]) {
                dfs(isConnected, i, hasVisited);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, int i, boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M, k, hasVisited);
            }
        }
    }

    public static void main(String[] args) {
        String str= "abc";
        System.out.println(str.substring(1,2));
    }
}
