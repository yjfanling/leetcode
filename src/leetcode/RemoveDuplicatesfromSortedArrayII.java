package leetcode;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        int pre=1,cur=1,count=1;
        while(pre<nums.length)
        {
        	while(pre<nums.length&&count<2)
        	{
        		if(pre<nums.length&&nums[pre]==nums[pre-1])
        		{
	        		nums[cur++]=nums[pre++];
	        		count++;
        		}
        		else
        		{
        			nums[cur++]=nums[pre++];
        			count=1;
        		}
        	}
        	while(pre<nums.length&&nums[pre]==nums[pre-1])
        	{
        		pre++;
        	}
        	count=1;
        }
		return cur;
    }
	public int removeDuplicates1(int[] nums) {
		if(nums.length<=2)
			return nums.length;
		int cur=0,pre=1,count=1;
		while(pre<nums.length)
		{
			if(nums[cur]==nums[pre]&&count==0)
				++pre;
			else
			{
				if(nums[cur]==nums[pre])
					--count;
				else
					count=1;
				nums[++cur]=nums[pre++];
			}
		}
		return cur+1;
	}
	public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
	@Test
	public void test() {
		int[] nums = {0,0,1,1,1,1,2,3,3,3};
		int d = removeDuplicates(nums);
		for (int i = 0; i < d; i++)
			System.out.print(nums[i] + "  ");
	}
}
