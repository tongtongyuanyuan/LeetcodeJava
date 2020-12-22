//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
//You have a queue of integers, you need to retrieve the first unique integer in the queue.
//
//Implement the FirstUnique class:
//
//FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
//int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
//void add(int value) insert value to the qu

import java.util.*;

// //similar to LRU, DoubledLinkedlist/queue with Hashmap
class FirstUnique {
    public class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int v) {
            val = v;
            next = null;
            prev = null;
        }
    }


    private class firstlist {  //定义了一个新的class
        private ListNode head;
        private ListNode tail;

        public firstlist() {   //constructor的写法
            head = new ListNode(-1);
            tail = new ListNode(-1);

            head.next = tail;
            tail.prev = head;
        }

        public ListNode getFirst() {
            return head.next;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        public void remove(ListNode node) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public ListNode append(int num) {  //append the node before the tail
            ListNode node = new ListNode(num);
            ListNode prev = tail.prev;
            prev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = prev;  //注意这里

            return node;
        }
    }


    // private ListNode kl; //c++用了list<int>::iterator, java用一个doubledlinkedlist
    private firstlist kl; //kl定义的新的class
    private Map < Integer, ListNode > m;

    public FirstUnique(int[] nums) {
        m = new HashMap <>();  //instantiate object
        kl = new firstlist();

        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        if (kl.isEmpty())
            return -1;
        return kl.getFirst().val; //对应linkedlist的第一个位置上的值
    }

    public void add(int value) {
        if (m.containsKey(value)) {  //map里面有，看看list里面的位置
            ListNode node1 = m.get(value);
            if (node1 != null) {   // c++里面list.end() == null表示在list中出现过
                kl.remove(node1);  //删掉
                m.put(value, null); //没了
            }
        } else {        //first appearance
            ListNode node2 = kl.append(value);  //加在list后面
            //找到在linkedlist中的位置更新在map中对应的位置
            m.put(value, node2);
        }
    }
}
//import java.util.LinkedHashSet;
//import java.util.Set;
//
////     }
//// } //Timelimit
//class FirstUnique {
//    private Set <Integer> set;
//    private Set<Integer> deque;
//    public FirstUnique(int[] nums) {
//
//        deque = new LinkedHashSet <Integer>();
//        set = new HashSet <Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                deque.remove(nums[i]);
//            }
//            else {
//                deque.add(nums[i]);
//            }
//
//            set.add(nums[i]);
//        }
//    }
//
//    public int showFirstUnique() {
//        if (deque.isEmpty()) {
//            return -1;
//        }
//        return deque.iterator().next();
//
//    }
//
//    public void add(int value) {
//
//        if (set.contains(value)) {
//            deque.remove(value);
//        }
//        else {
//            set.add(value);
//            deque.add(value);
//        }
//
//    }
//}
/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
