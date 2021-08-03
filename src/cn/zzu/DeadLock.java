package cn.zzu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yexuman
 * @version 1.0
 * @date 2021/6/17 下午11:46
 */
public class DeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                synchronized (lock1) {
                    System.out.println(name + " 拿到锁1 等锁2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println(name + " 拿到锁2了");
                        System.out.println(name + ": 开始业务!");
                    }
                }
            }
        }, "线程-A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                String name = Thread.currentThread().getName();
                synchronized (lock2) {
                    System.out.println(name + " 拿到锁2 等锁1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println(name + " 拿到锁1");
                        System.out.println(name + ": 开始业务操作");
                    }
                }

            }
        }, "线程-B").start();
    }

    public static int[] retainAll(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                list.add(array1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}

