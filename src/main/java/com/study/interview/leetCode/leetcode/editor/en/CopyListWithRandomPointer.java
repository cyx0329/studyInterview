//A linked list is given such that each node contains an additional random point
//er which could point to any node in the list or null. 
//
// Return a deep copy of the list. 
//
// The Linked List is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) where random pointe
//r points to, or null if it does not point to any node. 
// 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// Example 4: 
//
// 
//Input: head = []
//Output: []
//Explanation: Given linked list is empty (null pointer), so return null.
// 
//
// 
// Constraints: 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random is null or pointing to a node in the linked list. 
// Number of Nodes will not exceed 1000. 
// 
// Related Topics Hash Table Linked List


package com.study.interview.leetCode.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Node> map = new HashMap<>();
            Node node = head;
            while (node != null) {
                map.put(node, new Node(node.val));
                node = node.next;
            }
            node = head;
            while(node != null) {
                map.get(node).next = map.get(node.next);
                map.get(node).random = map.get(node.random);
                node = node.next;
            }
            return map.get(head);
        }

        /*
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node node = head;
            while(node != null) {
                Node next = node.next;
                node.next = new Node(node.val);
                node.next.next = next;
                node = next;
            }

            node = head;
            while(node != null) {
                if(node.random != null) {
                    node.next.random = node.random.next;
                }
                node = node.next.next;
            }

            node = head;
            Node newHead = head.next;
            Node copy = newHead;
            while(copy.next != null) {
                node.next = node.next.next;
                node = node.next;

                copy.next = copy.next.next;
                copy = copy.next;
            }
            node.next = node.next.next;
            return newHead;
        }
         */
    }
//leetcode submit region end(Prohibit modification and deletion)

}