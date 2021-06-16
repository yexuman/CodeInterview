package cn.zzu;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/2 下午5:33
 */
public class 圆圈中剩下的数 {

    /**
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * <p>
     * 如果没有小朋友，请返回-1
     */
    /*
     *这道题我用数组来模拟环，思路还是比较简单，但是各种下标要理清
     */
    public static int findLastNumber(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int index = 0;
        int count = n-1;
        int step = 1;
        while (count > 0) {
            index++;
            if (index >= n) {
                index = 0;  //模拟环  回到头
            }
            if (array[index] == -1) {
                continue;  //已经是无效的元素了
            }
            step++;  //步数+1
            if (step == m) {
                array[index] = -1; //置为无效
                step = 0;
                count--;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(Add(2,3));
    }

    public static int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

}
