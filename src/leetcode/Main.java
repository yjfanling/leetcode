package leetcode;

import java.io.*;
import java.util.*;

import org.junit.Test;

public class Main {

	//// public static void main(String[] args){
	//// Scanner sc=new Scanner(System.in);
	//// int n=sc.nextInt();
	//// int m=sc.nextInt();
	//// int k=sc.nextInt();
	//// int[] s=new int[n*m];
	//// for(int i=0;i<n*m;i++)
	//// {
	////
	//// }
	//// }
	// public static void main(String[] args){
	// Scanner sc=new Scanner(System.in);
	// int n=sc.nextInt();
	// int m=sc.nextInt();
	// int k=sc.nextInt();
	// int[][] s=new int[n][m];
	// for(int i=0;i<n;i++)
	// {
	// for(int j=0;j<m;j++)
	// s[i][j]=sc.nextInt();
	// }
	// int res=0;
	// for(int i=0;i<n;i++)
	// {
	// for(int j=0;j<m;j++)
	// {
	// if(isstar(s,i,j))
	// res++;
	// }
	// }
	// System.out.println(res);
	// }
	// private static boolean isstar(int[][] s, int i, int j) {
	// // TODO Auto-generated method stub
	// if(i-1>=0&&j-1>=0&&i+1<s.length&&j+1<s[0].length){
	// if(s[i][j]==s[i-1][j]&&s[i][j]==s[i+1][j]&&s[i][j]==s[i][j-1]&&s[i][j]==s[i][j+1])
	// return true;
	// }
	// return false;
	// }
	// 字节跳动货币问题 1元、4元、16元、64元，买东西用了n元，给老板1024元，最少会收到多少张钱
	// public static void main(String[] args) {
	// Scanner sc = new Scanner(System.in);
	// int n = 1024 - sc.nextInt();
	// int res = 0;
	// int index = 3;
	// while (index >= 0) {
	// if (n < 4) {
	// res += n;
	// break;
	// } else {
	// int count = n / (int) (Math.pow(4, index));
	// n = n - count * (int) (Math.pow(4, index--));
	// res += count;
	// }
	// }
	// System.out.println(res);
	//
	// }
	// 字节跳动程序改字符串 AABB->AAB、AAA->AA、AABBCC->AABCC
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		for (int i = 0; i < n; i++) {
//			String s = sc.next();
//			System.out.println(core(s));
//		}
//	}
//
//	private static String core(String s) {
//		// TODO Auto-generated method stub
//		char[] cs = s.toCharArray();
//		char[] tmp = new char[s.length()];
//		int index = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (index >= 2 && cs[i] == tmp[index - 1] && cs[i] == tmp[index - 2])
//				continue;
//			if (index >= 3 && cs[i] == tmp[index - 1] && tmp[index - 2] == tmp[index - 3])
//				continue;
//			tmp[index++] = cs[i];
//		}
//		tmp[index] = 0;
//		return new String(tmp).substring(0, index);
//	}
//	字节跳动 最少要多少奖品 n个人围成一圈，每个人的得分如果比左右高则奖品也要高
//	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
//		 int N=sc.nextInt();
//		 for(int i=0;i<N;i++)
//		 {
//			 int n=sc.nextInt();
//			 int[] goal=new int[n];
//			 for(int j=0;j<n;j++)
//				 goal[j]=sc.nextInt();
//			 int index=getmin(goal);
//			 int res=0;
//			 while(true)
//			 {
//				 
//			 }
//		 }
//	}
//
//	private static int getmin(int[] goal) {
//		// TODO Auto-generated method stub
//		int min=goal[0];
//		int index=0;
//		for(int i=0;i<goal.length;i++)
//			if(min>goal[i])
//			{
//				min=goal[i];
//				index=i;
//			}
//		return index;
//	}
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int N=sc.nextInt();
         int M=sc.nextInt();
         int[] a=new int[N];
         for(int i=0;i<N;i++)
        	 a[i]=sc.nextInt()*100;
         int left=0,right=10000000;
         while(left<=right)
         {
        	 int mid=(left+right)/2;
        	 if(mid==0)
        		 break;
        	 if(figure(mid,N,M,a))
        		 left=mid+1;
        	 else
        		 right=mid-1;
         }
	}
	private static boolean figure(int mid,int N,int M,int[] a) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1;i<=N;i++)
		{
			sum+=(int)(a[i]/mid);
		}
		return sum>=M;
	}
}
