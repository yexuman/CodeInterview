package cn.classify;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/5/17 下午8:16
 */
public class 翻转单词顺序列 {
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] arr = str.toCharArray();
        int i = 0;
        int j = 0;
        while (j <= n) {
            //代表前面就是一个单词了
            if (j == n || arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(arr, 0, n - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
