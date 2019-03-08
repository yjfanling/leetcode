package leetcode;import javax.sql.rowset.serial.SerialArray;

import org.junit.Test;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        	while(start<=end)
        	{
        		int mid=(start+end)/2;
        		if(nums[mid]==target)
        			return mid;
        		else if(nums[mid]<nums[end])
        		{
        			if(nums[mid]<target&&nums[end]>=target)
        				start=mid+1;
        			else
        				end=mid-1;
        		}
        		else{
        			if(nums[mid]>target&&nums[start]<=target)
        				end=mid-1;
        			else
        				start=mid+1;
        		}
        }
        return -1;
	}
	@Test
	public void test(){
		int[] nums={4,5,6,7,0,1,2};
		System.out.println(search(nums, 0));
	}
}
