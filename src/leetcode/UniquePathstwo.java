package leetcode;

import org.junit.Test;

public class UniquePathstwo {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null||obstacleGrid.length==0)
        	return 0;
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
        {
        	if(obstacleGrid[0][i]==1)
        		break;
        	dp[0][i]=1;
        }
        for(int i=0;i<m;i++)
        {
        	if(obstacleGrid[i][0]==1)
        		break;
        	dp[i][0]=1;
        }
        for(int i=1;i<n;i++)
        {
        	for(int j=1;j<m;j++)
        	{
        		if(obstacleGrid[i][j]==1)
        			dp[i][j]=0;
        		else
        			dp[i][j]=dp[i-1][j]+dp[i][j-1];
        	}
        }
        return dp[n-1][m-1];
	}
	@Test
	public void test(){
		int[][] o={{0,0}};
		System.out.println(uniquePathsWithObstacles(o));
	}
}
