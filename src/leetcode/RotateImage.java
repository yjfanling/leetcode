package leetcode;

import org.junit.Test;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n=matrix.length;
		//左右翻转
        for(int j=0;j<n/2;j++)
        	for(int i=0;i<n;i++)
        		swap(matrix,i,j,i,n-j-1);
        //对角线翻转
        for(int i=0;i<n-1;i++)
        	for(int j=0;j<n-1-i;j++)
        		swap(matrix,i,j,n-1-j,n-1-i);
    }
	private void swap(int[][] matrix, int i, int j, int p, int q) {
		// TODO Auto-generated method stub
		int tmp=matrix[i][j];
		matrix[i][j]=matrix[p][q];
		matrix[p][q]=tmp;
	}
	
	@Test
	public void test(){
		int[][] matrix={{ 5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
		rotate(matrix);
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix.length;j++)
			{
				System.out.print(matrix[i][j]+"     ");
			}
			System.out.println();
		}
	}
}
