package leetcode;

import org.junit.Test;

public class TreeNodeFactory {
	int index=1;
	public static TreeNode buildTreeByArray(int[] a,int n){
		TreeNode[] p=new TreeNode[n+1];
		p[0]=null;
		for(int i=1;i<=n;i++)
		{
			if(a[i-1]==-1){
				p[i]=null;
			}
			else
			{
				p[i]=new TreeNode(a[i-1]);
			}
		}
		for(int i=1;i<=n/2;i++){
			if(a[i-1]!=-1){
				if((2*i-1<n)&&a[2*i-1]!=-1)
				{
					p[i].setLeft(p[2*i]);
				}
				if((2*i<n)&&(a[2*i]!=-1)){
					p[i].setRight(p[2*i+1]);
				}
			}
		}
		return p[1];
	}
	public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null)
        	return null;
        return KthNodeCore(pRoot,k);
    }
	private TreeNode KthNodeCore(TreeNode pRoot, int k) {
		// TODO Auto-generated method stub
		TreeNode temp=null;
		if(pRoot.left!=null)
			temp=KthNodeCore(pRoot.left, k);
		if(temp==null)
		{
			if(index==k)
				temp=pRoot;
			index++;
		}
		if(temp==null&&pRoot.right!=null)
		{
			temp=KthNodeCore(pRoot.right, k);
		}
		return temp;
	}
	@Test
	public void test(){
		TreeNodeFactory t=new TreeNodeFactory();
		int[] a={-44,-1,-35,-38,45,-40,-36,41,49,-43,-1,-1,-1,3,42,48,-1,-1,-1,-21,6,-1,-1,47,-1,-34,-13,4,14,46,-1,-1,-27,-17,-7,-1,-1,8,39,-1,-1,-28,-24,-20,-15,-10,0,-1,11,37,-1,-33,-1,-1,-23,-1,-19,-1,-1,-1,-1,-5,2,9,12,16,-1,-1,-30,-1,-22,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-29,-1,-1,-1,-1,-1,32,-1,-1,31,-1,26,-1,25};
		TreeNode tn=t.buildTreeByArray(a, a.length);
	}
}
