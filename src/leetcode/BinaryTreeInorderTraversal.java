package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		dfs(res, root);
		return res;
	}

	private void dfs(List<Integer> res, TreeNode root) {
		// TODO Auto-generated method stub
		if (root.left != null)
			dfs(res, root.left);
		res.add(root.val);
		if (root.right != null)
			dfs(res, root.right);
	}

	public List<Integer> inorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		TreeNode tmp = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (tmp != null || !stack.isEmpty()) {
			while (tmp != null) {
				stack.add(tmp);
				tmp = tmp.left;
			}
			tmp = stack.pop();
			res.add(tmp.val);
			tmp = tmp.right;
		}
		return res;
	}
}
