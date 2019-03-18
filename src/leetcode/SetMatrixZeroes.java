package leetcode;

import java.util.Arrays;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix==null||matrix.length==0)
			return;
		int n=matrix.length;
		int m=matrix[0].length;
		boolean col=false;
		boolean row=false;
		for(int i=0;i<n;i++)
			if(matrix[i][0]==0)
				col=true;
		for(int i=0;i<m;i++)
			if(matrix[0][i]==0)
				row=true;
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++)
				if(matrix[i][j]==0)
				{
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
		for(int i=1;i<n;i++)
		{
			if(matrix[i][0]==0)
				Arrays.fill(matrix[i], 0);
		}
		for(int i=1;i<m;i++)
			if(matrix[0][i]==0)
				for(int j=1;j<n;j++)
					matrix[j][i]=0;
		if(row)
			Arrays.fill(matrix[0], 0);
		if(col)
			for(int i=0;i<n;i++)
				matrix[i][0]=0;
    }
	public void setZeroes1(int[][] matrix) {
		if(matrix==null||matrix.length==0)
			return;
		int n=matrix.length;
		int m=matrix[0].length;
		int k=0;
		while(k<m&&matrix[0][k]!=0)
			++k;
		for(int i=1;i<n;i++)
			for(int j=0;j<m;j++)
				if(matrix[i][j]==0)
					matrix[i][0]=matrix[0][j]=0;
		for(int i=1;i<n;i++)
			for(int j=m-1;j>=0;j--)
				if(matrix[0][j]==0||matrix[i][0]==0)
					matrix[i][j]=0;
		if(k<m)
			Arrays.fill(matrix[0], 0);
	}
}
