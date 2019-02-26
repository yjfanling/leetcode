package leetcode;

import org.junit.Test;

public class MaximumSubarray {
	 public int maxSubArray(int[] nums) {
	     if(nums==null||nums.length==0)
	    	 return 0;
	     int max=nums[0],cur=nums[0];
		 for(int i=1;i<nums.length;i++)
		 {
			 cur=cur+nums[i]>nums[i]?cur+nums[i]:nums[i];
			 max=max>cur?max:cur;
//			 cur+=nums[i];
//			 if(cur<nums[i])
//				 cur=nums[i];
//			 if(max<cur)
//				 max=cur;
		 }
		 return max;
	 }
	 public int maxSubArray1(int[] nums) {
	     if (nums.length == 0) return 0;
	     return helper(nums, 0, nums.length - 1);
	 }
	 public int helper(int[] nums, int left, int right) {
	     if (left >= right) return nums[left];
	     int mid = left + (right - left) / 2;
	     int lmax = helper(nums, left, mid - 1);
	     int rmax = helper(nums, mid + 1, right);
	     int mmax = nums[mid], t = mmax;
	     for (int i = mid - 1; i >= left; --i) {
	         t += nums[i];
	         mmax = Math.max(mmax, t);
	     }
	     t = mmax;
	     for (int i = mid + 1; i <= right; ++i) {
	         t += nums[i];
	         mmax = Math.max(mmax, t);
	     }
	     return Math.max(mmax, Math.max(lmax, rmax));
	 }
	 @Test
	 public void test(){
		 int[] nums={1};
		 System.out.println(maxSubArray1(nums));
	 }
}
