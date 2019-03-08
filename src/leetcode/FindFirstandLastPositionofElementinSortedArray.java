package leetcode;

import org.junit.Test;

public class FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1;
        int mid=(start+end)/2;
        while(start<=end){
        	if(nums[mid]==target)
        		break;
        	else if(nums[mid]<target)
        		start=mid+1;
        	else 
        		end=mid-1;
        	mid=(start+end)/2;
        }
        if(start>end)
        	return new int[]{-1,-1};
        int left=mid,right=mid;
        while(left>0&&nums[left]==nums[left-1])
        	left--;
        while(right<nums.length-1&&nums[right]==nums[right+1])
        	right++;
        return new int[]{left,right};
    }
	public int[] searchRange1(int[] nums, int target) {
		int start=0,end=nums.length;
		
		while(start<end)
		{
			int mid=(start+end)/2;
        	if(nums[mid]<target)
        		start=mid+1;
        	else 
        		end=mid;
		}
		if(nums[end]!=target)
			return new int[]{-1,-1};
		int left=end;
		end=nums.length;
		while(start<end)
		{
			int mid=(start+end)/2;
			
        	if(nums[mid]<=target)
        		start=mid+1;
        	else 
        		end=mid;
		}
		int right=start-1;
		return new int[]{left,right};
	}
	@Test
	public void test()
	{
		int[] nums={};
		int[] res=searchRange(nums, 0);
		System.out.println(res[0]);
	}
}
