package leetcode;

import org.junit.Test;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0||target<nums[0])
        	return 0;
        int length=nums.length;
        for(int i=0;i<length;i++)
        {
        	if(target<=nums[i])
        		return i;
        }
        return length;
    }
	public int searchInsert1(int[] nums, int target) {
		if(nums==null||nums.length==0||target<nums[0])
        	return 0;
		int length=nums.length;
		if(nums[length-1]<target)
			return length;
		int start=0,end=nums.length-1;
		while(start<end)
		{
			int mid=(start+end)/2;
			if(nums[mid]==target)
				return mid;
			else if(nums[mid]<target)
				start=mid+1;
			else
				end=mid;
		}
		return end;
	}
	@Test
	public void test()
	{
		int[] nums={1,3,5,6};
		int target=0;
		System.out.println(searchInsert1(nums, target));
	}
}
