package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null)
        	return true;
        if(p==null||q==null)
        	return false;
        if(p.val==q.val)
        	return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        else 
        	return false;
    }
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if(p==null&&q==null)
        	return true;
		if(p==null||q==null)
        	return false;
		Queue<TreeNode> q1=new LinkedList<TreeNode>();
		Queue<TreeNode> q2=new LinkedList<TreeNode>();
		q1.add(p);
		q2.add(q);
		while(!q1.isEmpty()&&!q2.isEmpty())
		{
			TreeNode t1=q1.poll();
			TreeNode t2=q2.poll();
			if(t1.val!=t2.val)
				return false;
			q1.add(t1.left);
			q1.add(t1.right);
			q1.add(t2.left);
			q1.add(t2.right);
		}
		return true;
	}
}
