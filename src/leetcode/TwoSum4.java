package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class TwoSum4 {
	public boolean findTarget(TreeNode root, int k) {
		if(root==null)
			return false;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		return find(root,k,map);
	}

	private boolean find(TreeNode root, int k, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(root==null)
			return false;
		if(map.containsKey(k-root.val))
			return true;
		else
			map.put(root.val, 1);
		return find(root.left,k,map)||find(root.right,k,map);
	}
	public boolean findTarget1(TreeNode root, int k) {
		if(root==null)
			return false;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode tmp=q.poll();
			if(map.containsKey(k-tmp.val))
				return true;
			else
				map.put(tmp.val, 1);
			if(tmp.left!=null)
				q.add(tmp.left);
			if(tmp.right!=null)
				q.add(tmp.right);
		}
		return false;
	}
	public boolean findTarget2(TreeNode root, int k) {
		if(root==null)
			return false;
		return dfs(root,root,k);
	}

	private boolean dfs(TreeNode root, TreeNode cur, int k) {
		// TODO Auto-generated method stub
		if(cur==null)
			return false;
		return search(cur,root,k-cur.val)||dfs(root,cur.left,k)||dfs(root,cur.right,k);
	}

	private boolean search(TreeNode root, TreeNode cur, int i) {
		// TODO Auto-generated method stub
		if(cur==null)
			return false;
		if(cur!=root&&cur.val==i)
			return true;
		return cur.val<i?search(root, cur.right, i):search(root, cur.left, i);
	}
}
