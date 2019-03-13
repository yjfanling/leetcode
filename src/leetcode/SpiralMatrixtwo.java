package leetcode;

public class SpiralMatrixtwo {
	public int[][] generateMatrix(int n) {
		int up=0,down=n-1,left=0,right=n-1;
		int[][] res=new int[n][n];
		int index=1;
		while(true){
			for(int j=left;j<=right;j++)
				res[up][j]=index++;
			if(++up>down)
				break;
			for(int j=up;j<=down;j++)
				res[j][right]=index++;
			if(--right<left)
				break;
			for(int j=right;j>=left;j--)
				res[down][j]=index++;
			if(--down<up)
				break;
			for(int j=down;j>=up;j--)
				res[j][left]=index++;
			if(++left>right)
				break;
		}
	    return res;
	}
}
