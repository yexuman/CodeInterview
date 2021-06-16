package cn.zzu.hot100_part1;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/9/14 11:56 上午
 */
public class Leetcode621_任务调度器 {
    /**
     * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，
     * 并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
     * <p>
     * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * <p>
     * 你需要计算完成所有任务所需要的最短时间。
     * <p>
     *  
     * <p>
     * 示例 ：
     * <p>
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
     * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     *  
     * <p>
     * 提示：
     * <p>
     * 任务的总个数为 [1, 10000]。
     * n 的取值范围为 [0, 100]。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/task-scheduler
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];

        for (char c : tasks) {
            counts[c - 'A'] += 1;
        }

        //找出现最多的任务  记录个数
        int max = 0;
        for (int count : counts) {
            max = Math.max(max, count);
        }

        //相当于找最后一行的的元素个数
        int maxCount = 0;
        for (int count : counts) {
            if (count == max) {
                maxCount++;
            }
        }
        return Math.max((n + 1) * (max - 1) + maxCount, tasks.length);
    }
}
