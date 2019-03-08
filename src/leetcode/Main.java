package leetcode;

import java.io.*;
import java.util.*;

import org.junit.Test;
public class Main
{
	
//	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
//     	int n=sc.nextInt();
//     	int m=sc.nextInt();
//     	int k=sc.nextInt();
//     	int[] s=new int[n*m];
//     	for(int i=0;i<n*m;i++)
//     	{
//     		
//     	}
//    }
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
     	int n=sc.nextInt();
     	int m=sc.nextInt();
     	int k=sc.nextInt();
     	int[][] s=new int[n][m];
     	for(int i=0;i<n;i++)
     	{
     		for(int j=0;j<m;j++)
     			s[i][j]=sc.nextInt();
     	}
     	int res=0;
     	for(int i=0;i<n;i++)
     	{
     		for(int j=0;j<m;j++)
     		{
     			if(isstar(s,i,j))
     				res++;
     		}
     	}
     	System.out.println(res);
    }
	private static boolean isstar(int[][] s, int i, int j) {
		// TODO Auto-generated method stub
		if(i-1>=0&&j-1>=0&&i+1<s.length&&j+1<s[0].length){
			if(s[i][j]==s[i-1][j]&&s[i][j]==s[i+1][j]&&s[i][j]==s[i][j-1]&&s[i][j]==s[i][j+1])
				return true;
		}
		return false;
	}
}
                            