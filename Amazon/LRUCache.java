package Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Wrong Answer 15 / 23 testcases passed
 * Miss Hit: If the key already exists put()
 * 51ms Beats 30.36%
*/
public class LRUCache {
    private class Node {
        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMap<Integer, Node> map;
    private final int capacity;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = this.tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){ return -1; }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if(map.size()>capacity){
                removeNode(tail.pre);
            }
        }
    }

    private void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        /*
         * If you remove this line
         * 44ms Beats 79.12%
        */
        map.remove(node.key);
    }

    private void moveToHead(Node node){
        removeNode(node);
        map.put(node.key, node);
        addToHead(node);
    }
}

