package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
            return res;
		int n=matrix.length;
		int m=matrix[0].length;
		boolean[][] visited=new boolean[n][m];
		for(int i=0;i<n;i++)
		{	if(i>m-1||visited[i][i])
				break;
			right(matrix,visited,res,i,i,m-1-i);
			if(i>m-1||i>=n-1||visited[i+1][m-1-i])
				break;
			down(matrix,visited,res,m-1-i,i+1,n-1-i);
			if(i>m-2||i>n-1||visited[n-1-i][m-2-i]||i>m-2)
				break;
			left(matrix,visited,res,n-1-i,m-2-i,i);
			if(i>n-2||i>=m||visited[n-2-i][i])
				break;
			up(matrix,visited,res,i,n-2-i,1+i);
		}
		return res;
	}
	private void up(int[][] matrix, boolean[][] visited, List<Integer> res, int col, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=start;i>=end;i--)
		{
			if(visited[i][col])
				break;
			visited[i][col]=true;
			res.add(matrix[i][col]);
		}
	}

	private void left(int[][] matrix, boolean[][] visited, List<Integer> res, int row, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=start;i>=end;i--)
		{
			if(visited[row][i])
				break;
			visited[row][i]=true;
			res.add(matrix[row][i]);
		}
	}

	private void down(int[][] matrix, boolean[][] visited, List<Integer> res, int col, int start, int end) {
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++)
		{
			if(visited[i][col])
				break;
			visited[i][col]=true;
			res.add(matrix[i][col]);
		}
	}
    private void right(int[][] matrix, boolean[][] visited, List<Integer> res, int row,int start,int end) {
		// TODO Auto-generated method stub
		for(int i=start;i<=end;i++)
		{
			if(visited[row][i])
				break;
			visited[row][i]=true;
			res.add(matrix[row][i]);
		}
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
    	List<Integer> res=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0)
            return res;
		int n=matrix.length;
		int m=matrix[0].length;
		int up=0,down=n-1,left=0,right=m-1;
		while(true){
			for(int j=left;j<=right;j++)
				res.add(matrix[up][j]);
			if(++up>down)
				break;
			for(int j=up;j<=down;j++)
				res.add(matrix[j][right]);
			if(--right<left)
				break;
			for(int j=right;j>=left;j--)
				res.add(matrix[down][j]);
			if(--down<up)
				break;
			for(int j=down;j>=up;j--)
				res.add(matrix[j][left]);
			if(++left>right)
				break;
		}
		return res;
    }
}
