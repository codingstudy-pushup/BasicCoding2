package ama_onsi;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class ConstructInPost {

	public static void main(String[] args) {
		ConstructInPost a = new ConstructInPost();
		int[] inorder =   { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		a.buildTree_1(inorder, postorder);
	}
	
	  public TreeNode buildTree_1(int[] inorder, int[] postorder) {
	      return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);    
	    }
	    
	    TreeNode helper(int[] inorder, int[] postorder, int pLength, int is, int ie){
	    	
	      System.out.println("pLength: "+pLength+" is "+is+" ie "+ie);	
	      if(pLength >= postorder.length || is > ie) return null;
	      TreeNode node = new TreeNode(postorder[pLength]);
	      int inorder_index = 0;
	      for(int i = 0; i < inorder.length; i++){
	        if( inorder[i] == postorder[pLength]) {
	        	System.out.println("inorder["+i+"] "+inorder[i]+"  postorder["+pLength+"] "+ postorder[pLength]);
	        	inorder_index = i;  
	        	System.out.println("inorder_index "+inorder_index);
	        }
	      }
	      node.left = helper(inorder, postorder, pLength - 1 - ie + inorder_index, is, inorder_index - 1);
	     
	      node.right = helper(inorder, postorder, pLength - 1 , inorder_index + 1, ie);
	      return node;
	    }

	int post_idx;
	int[] postorder;
	int[] inorder;
	HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

	public TreeNode helper(int in_left, int in_right) {
		// if there is no elements to construct subtrees
		System.out.println("in_left:"+in_left+" in_right:"+in_right);
		if (in_left > in_right)
			return null;

		// pick up post_idx element as a root
		int root_val = postorder[post_idx];
		System.out.println("root_val: "+root_val);
		TreeNode root = new TreeNode(root_val);

		// root splits inorder list
		// into left and right subtrees
		int index = idx_map.get(root_val);

		// recursion
		post_idx--;
		// build right subtree
		root.right = helper(index + 1, in_right);
		// build left subtree
		root.left = helper(in_left, index - 1);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.postorder = postorder;
		this.inorder = inorder;
		// start from the last postorder element
		post_idx = postorder.length - 1;

		// build a hashmap value -> its index
		int idx = 0;
		for (Integer val : inorder)
			idx_map.put(val, idx++);
		return helper(0, inorder.length - 1);
	}

}
