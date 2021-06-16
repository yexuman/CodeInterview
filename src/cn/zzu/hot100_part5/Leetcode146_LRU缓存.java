package cn.zzu.hot100_part5;

import java.util.HashMap;

/**
 * @author yexuman
 * @version 1.0
 * @date 2020/12/9 17:30
 */
public class Leetcode146_LRU缓存 {
    private static class Node {
        int key, value;
        Node next, prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public Leetcode146_LRU缓存(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            update(node);
            return node.value;
        }
        return -1;
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    // 在表尾追加
    private void add(Node node) {
        Node l = tail;
        tail = node;
        if (l == null) {
            head = node;
        } else {
            l.next = node;
            node.prev = l;
            node.next = null;
        }
        capacity--;
    }

    // 删除结点
    private void remove(Node node) {
        Node prev = node.prev, next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
        }
        capacity++;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            update(node);
        } else {  // 不存在，插入
            node = new Node(key, value);
            map.put(key, node);
            add(node);

        }

        if (capacity < 0) {
            Node temp = head;
            remove(head);
            map.remove(temp.key);
        }
    }
}
