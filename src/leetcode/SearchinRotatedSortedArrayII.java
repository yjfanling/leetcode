package leetcode;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0)
        	return false;
        int start=0,end=nums.length;
        while(start<=end)
        {
        	int mid=(start+end)/2;
        	if(nums[mid]==target)
        		return true;
        	else if(nums[mid]<target)
        	{
        		if(nums[end]==target)
        			return true;
        		else if(nums[end]<target)
        		{
        			end=mid-1;
        			while(end>start&&nums[end]==nums[end-1])
        				end--;
        		}
        		else 
        		{
        			start=mid+1;
        			while(end>start&&nums[start]==nums[start+1])
        				start++;
        		}
        	}
        	else
        	{
        		if(nums[start]==target)
        			return true;
        		else if(nums[start]<target)
        		{
        			end=mid-1;
        			while(end>start&&nums[end]==nums[end-1])
        				end--;
        		}
        		else 
        		{
        			start=mid+1;
        			while(end>start&&nums[start]==nums[start+1])
        				start++;
        		}
        	}
        }
		return false;
    }
}
