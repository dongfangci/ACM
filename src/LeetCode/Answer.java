package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Answer {
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}

/*
  136. Single Number
  Given an array of integers, every element appears twice except for one. 
  Find that single one.

  Note:
  Your algorithm should have a linear runtime complexity. 
  Could you implement it without using extra memory?
 */
	class Solution {
	    public int singleNumber(int[] nums) {
	        int result = 0;
	        for(int i = 0;i<nums.length;i++){
	        result = result ^ nums[i];
	        }
	        return result;
	}
	}
/*I'm sure for a lot of people this may be confusing as to why this works. 
 * The idea hinges on 3 properties of xor. 
 * (1) that its a commutative operation (i.e. a xor b = b xor a).
 * (2) that something xor itself is 0. So a xor a = 0. 
 * (3) 0 xor a = a. These three properties mean that 

	a xor b xor a = a xor a xor b = 0 xor b = b. 

 * */
	
	
/*145.
 * Preorder, Inorder and Postorder Traversal Iterative Java Solution
 * 
 * 
 * 
 * */
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    if(root == null) return list;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while(!stack.empty()){
	        root = stack.pop();
	        list.add(root.val);
	        if(root.right != null) stack.push(root.right);
	        if(root.left != null) stack.push(root.left);
	    }
	    return list;
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    if(root == null) return list;
	    Stack<TreeNode> stack = new Stack<>();
	    while(root != null || !stack.empty()){
	        while(root != null){
	            stack.push(root);
	            root = root.left;
	        }
	        root = stack.pop();
	        list.add(root.val);
	        root = root.right;
	    }
	    return list;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> list = new ArrayList<>();
	    if(root == null) return list;
	    Stack<TreeNode> stack = new Stack<>();
	    stack.push(root);
	    while(!stack.empty()){
	        root = stack.pop();
	        list.add(0, root.val);
	        if(root.left != null) stack.push(root.left);
	        if(root.right != null) stack.push(root.right);
	    }
	    return list;
	}
	
	
	
	
	
}