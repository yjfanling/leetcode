package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int res=0;
        int diff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
        	int j=i+1,k=nums.length-1;
        	while(j<k)
        	{
        		int sum=nums[i]+nums[j]+nums[k];
        		if(sum==target)
        			return target;
        		else
        		{
        			if(diff>Math.abs(target-sum))
            			{
            				diff=Math.abs(target-sum);
            				res=sum;
            			}
        			if(sum<target)
        				j++;
        			else
        				k--;
        		}
        	}
        }
        return res;
    }
	@Test
	public void test(){
		int[] nums={1,1,-1,-1,3};
		int[] nums1={-1,0,1,1,55};
		System.out.println(threeSumClosest(nums1, 3));
	}
}
