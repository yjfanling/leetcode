package leetcode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	private int size=0;
	private int leftsize=0;
	TreeNode(int x) 
	{ 
		val = x; 
	}
	 public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
	    public void insert(int a)
	    {
	    	if(val>=a)
	    	{
	    		if(left!=null)
	    		{
	    			left.insert(a);
	    		}
	    		else
	    		{
	    			left=new TreeNode(a);
	    		}
	    		leftsize++;
	    		size++;
	    	}
	    	else
	    	{
	    		if(right!=null)
	    			right.insert(a);
	    		else
	    			right=new TreeNode(a);
	    		size++;
	    	}
	    }
	    public int getRank(int v)
	    {
	    	if(v==val)
	    		return leftsize;
	    	else if(v<val)
	    		return left.getRank(v);
	    	else
	    		return leftsize+1+right.getRank(v);
	    }
}
