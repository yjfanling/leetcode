package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
        int[][] dp=new int[n][m];
        Arrays.fill(dp[0], 1);
        for(int i=0;i<n;i++)
        	dp[i][0]=1;
        for(int i=1;i<n;i++)
        	for(int j=1;j<m;j++)
        		dp[i][j]=dp[i-1][j]+dp[i][j-1];
        return dp[n-1][m-1];
	}
	@Test
	public void test(){
		System.out.println(uniquePaths(51, 9));
	}
}
