//Given a binary tree, determine if it is a valid binary search tree (BST). 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
//
// Example 1: 
//
// 
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
// Related Topics Tree Depth-first Search


package com.study.interview.leetCode.leetcode.editor.en;




public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        Solution solution = new ValidateBinarySearchTree().new Solution();

        TreeNode node3 = new TreeNode(3);
        node3.left = null;
        node3.right = null;
        TreeNode node6 = new TreeNode(6);
        node6.left = null;
        node6.right = null;
        TreeNode node1 = new TreeNode(1);
        node1.left = null;
        node1.right = null;
        TreeNode node4 = new TreeNode(4);
        node4.left = node3;
        node4.right = node6;
        TreeNode root = new TreeNode(5);
        root.left = node1;
        root.right = node4;
        boolean b = solution.isValidBST(root);
        System.out.println(b);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;

            int val = node.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (! helper(node.right, val, upper)) return false;
            if (! helper(node.left, lower, val)) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}