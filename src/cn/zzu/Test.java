package cn.zzu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/28 下午9:32
 */
public class Test {
    /**
     * 在一个逆序的整数数组中，查找大于等于X的最后一个元素下标。
     * 如果不存在大于等于X的元素，返回-1。
     * @param arr
     * @param x
     * @return
     */
   public static int find(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid]>=x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(right==0)
            return -1;
        return left ;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 8 ,7 ,7 ,7 ,6 ,5, 5, 3,2};
        System.out.println(find(arr,7));
        System.out.println(find(arr,4));
        System.out.println(find(arr,1));
        System.out.println(find(arr,10));

    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        // 气球的终止位置
        int end = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            res++;
            end = points[i][1];
        }
        return res;
    }

}
