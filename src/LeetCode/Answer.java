package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	
/*144. / 145. TreeOrder
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
	
	 public List<Integer> postorderTraversal2(TreeNode root) {	//更加一般的解法，同样适用于中序遍历
	       List<Integer> list = new ArrayList<Integer>();
	       if(root == null)
	       return list;
	       Stack<TreeNode> s = new Stack<TreeNode>();
	       HashMap<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
	       TreeNode p = null;
	       s.push(root);
	       map.put(root,0);
	       while(!s.isEmpty()){
	           p = s.pop();
	           
	          if(map.get(p) == 0){				//	第一次压栈
	            s.push(p);
	            map.put(p,1);					//第二次压栈
	            if(p.right != null){
	             s.push(p.right);
	            map.put(p.right,0);
	            }
	            if(p.left != null){
	            s.push(p.left);
	            map.put(p.left,0);       
	            }
	          }
	         else
	         list.add(p.val);
	          
	       }
	       return list;
	    }
/*
 * 104. Maximum Depth of Binary Tree
 * Given a binary tree, find its maximum depth.
   The maximum depth is the number of nodes along the longest 
   path from the root node down to the farthest leaf node.
 * */ 
 
	
	 public int maxDepth(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        Map<TreeNode, Integer> depthMap = new HashMap<>();
	        depthMap.put(root, 1);
	        int maxDepth = 1;
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            root = stack.pop();
	            int depth = depthMap.get(root);
	            maxDepth = Math.max(maxDepth, depthMap.get(root));
	            if (root.right != null) {
	                depthMap.put(root.right, depth + 1);
	                stack.push(root.right);
	            }
	            if (root.left != null) {
	                depthMap.put(root.left, depth + 1);
	                stack.push(root.left);
	            }
	            depthMap.remove(root);
	        }
	        return maxDepth;
	    }
	 
	 public int maxDepth2(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        int left = maxDepth2(root.left);
	        int right = maxDepth2(root.right);
	        return((left > right) ? left + 1 : right + 1);
	 }
	
}