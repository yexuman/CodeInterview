package cn.zzu.hot100_part2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/25 1:06 下午
 */
public class Leetcode406_根据身高重建队列 {
    /**
     * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
     *
     * 注意：
     * 总人数少于1100人。
     *
     * 示例
     *
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     *
     */

    /**
     * 排序：
     * 按高度降序排列。
     *      在同一高度的人中，按 k 值的升序排列。
     * 逐个地把它们放在输出队列中，索引等于它们的 k 值。
     * 返回输出队列
     * @param people
     * @return
     */
    /**
     * 时间复杂度：\mathcal{O}(N^2)O(N
     * 2
     *  )。排序使用了 \mathcal{O}(N \log N)O(NlogN) 的时间，每个人插入到输出队列中需要 \mathcal{O}(k)O(k) 的时间，其中 kk 是当前输出队列的元素个数。总共的时间复杂度为 \mathcal{O}\left({\sum\limits_{k = 0}^{N - 1}{k}}\right)O(
     * k=0
     * ∑
     * N−1
     * ​
     *  k) = \mathcal{O}(N^2)O(N
     * 2
     *  )。
     * 空间复杂度：\mathcal{O}(N)O(N)，输出队列使用的空间。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // h降序  如果h相等  就k升序
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> res = new LinkedList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }

        int n = people.length;
        return res.toArray(new int[n][2]);
    }




}
