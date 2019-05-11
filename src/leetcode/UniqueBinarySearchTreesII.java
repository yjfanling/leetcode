package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        if(n<1)
        	return new ArrayList<TreeNode>();
		return core(1,n);
    }

	private List<TreeNode> core(int start, int end) {
		// TODO Auto-generated method stub
		List<TreeNode> res =new ArrayList<TreeNode>();
		if(start>end){
			res.add(null);
			return res;
		}
		for(int i=start;i<=end;i++)
		{
			List<TreeNode> left=core(start,i-1);
			List<TreeNode> right=core(i+1,end);
			for(TreeNode l:left){
				for(TreeNode r:right){
					TreeNode root=new TreeNode(i);
					root.left=l;
					root.right=r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
