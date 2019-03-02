package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class LongestPalindromicSubstring {
	int start=0,maxLength=0;
	public String longestPalindrome(String s) {
		if(s.length()<2)
			return s;
		for(int i=0;i<s.length();i++)
		{
			searchPalindrom(s,i,i);
			searchPalindrom(s,i,i+1);
		}
		return s.substring(start,maxLength+start);
    }

	private void searchPalindrom(String s,int left,int right) {
		// TODO Auto-generated method stub
		while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
		{
			left--;
			right++;
		}
		if(maxLength<right-left-1){
			start=left+1;
			maxLength=right-left-1;
		}
	}
	public String longestPalindrome1(String s) {
		if(s.length()<2)
			return s;
		int n=s.length(),maxLength=0,start=0;
		for(int i=0;i<n;)
		{
			if((n-i)<maxLength/2)
				break;
			int left=i,right=i;
			while(right<n-1&&s.charAt(right+1)==s.charAt(right))
				right++;
			i=right+1;
			while(left>0&&right<n-1&&s.charAt(right+1)==s.charAt(left-1))
			{
				left--;
				right++;
			}
			if(maxLength<right-left+1){
				start=left;
				maxLength=right-left+1;
			}
		}
		return s.substring(start,maxLength+start);
	}
	public String longestPalindrome2(String s) {
		if(s.length()<2)
			return s;
		boolean[][] dp=new boolean[s.length()][s.length()];
		int length=0,left=0,right=0;
		for(int i=0;i<s.length();i++){
			for(int j=0;j<i;j++)
			{
				if(s.charAt(i)==s.charAt(j)&&(i-j<2||dp[j+1][i-1]))
					dp[j][i]=true;
				if(dp[j][i]&&length<i-j+1)
				{
					length=i-j+1;
					left=j;
					right=i;
				}
			}
			dp[i][i]=true;
		}
		return s.substring(left,right+1);
	}
	@Test
	public void test()
	{
		String s="abcdbbfcba";
		System.out.println(longestPalindrome2(s));
	}
}
