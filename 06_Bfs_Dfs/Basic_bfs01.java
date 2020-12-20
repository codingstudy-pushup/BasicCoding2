package Bfs_Dfs;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int x) {
		this.val = x;
	}
}

public class Basic_bfs01 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(solve(root));
	}

	public static List<List<Integer>> solve(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean zigzag = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (zigzag) {
					list.add(node.val);
				} else {
					list.add(0, node.val);
				}

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}

			}
			zigzag = !zigzag;
			result.add(list);
		}
		return result;
	}
}
