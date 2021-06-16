package cn.zzu.hot100_part4;

import java.util.ArrayList;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/11/18 18:37
 */
public class Leetcode200_岛屿数量 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     *  
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j, m, n);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int m, int n) {
        //没有被访问过  并且=1
        if (i>=0&&i<m&&j>=0&&j<n&&!visited[i][j]&&grid[i][j]=='1') {
            visited[i][j]=true;
            dfs(grid, visited, i-1, j, m, n);
            dfs(grid, visited, i+1, j, m, n);
            dfs(grid, visited, i, j-1, m, n);
            dfs(grid, visited, i, j+1, m, n);
        }
    }

    //顺时针打印矩阵
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int a=0;
        int b=0;
        int c=matrix.length-1;
        int d=matrix[0].length-1;
        while (a <= c && b <= d) {
            help(matrix,a++,b++,c--,d--);
        }
        return list;
    }

    private void help(int[][] matrix, int a, int b, int c, int d) {
        if (a==c){
            for (int i=b;i<=d;i++){
                list.add(matrix[a][i]);
            }
        }else if (b==d){
            for (int i=a;i<=c;i++){
                list.add(matrix[i][b]);
            }
        }else {
            //既不同行  又不同列
            int cRow=a;
            int cCol=b;
            while (cCol!=d){
                list.add(matrix[cRow][cCol++]);
            }
            while (cRow!=c){
                list.add(matrix[cRow++][cCol]);
            }
            while (cCol!=b){
                list.add(matrix[cRow][cCol--]);
            }
            while (cRow!=a){
                list.add(matrix[cRow--][cCol]);
            }
        }
    }
}
