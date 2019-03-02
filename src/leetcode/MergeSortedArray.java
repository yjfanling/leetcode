package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        int i=m-1,j=n-1;
        while(i>=0&&j>=0)
        	nums1[k--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
 }
	 @Test
	 public void test()
	 {
		 int[] nums1={1,2,3,0,0,0};
		 int[] nums2={2,5,6};
		 merge(nums1, 3, nums2, 3);
		 for(int i=0;i<nums1.length;i++)
			 System.out.println(nums1[i]+" ");
	 }
	 
}
