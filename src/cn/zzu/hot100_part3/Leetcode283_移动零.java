package cn.zzu.hot100_part3;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/10/12 1:27 下午
 */
public class Leetcode283_移动零 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/move-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //思路：设置一个index，表示非0数的个数，循环遍历数组，
    // 如果不是0，将非0值移动到第index位置,然后index + 1
    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = left + 1;
        while (left < nums.length && right < nums.length) {
            if (nums[left] == 0) {
                if (nums[right] != 0) {
                    swapNum(nums, left++, right++);
                }else {
                    right++;
                }
            }else {
                left++;
                right++;
            }
        }
    }

    private void swapNum(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
