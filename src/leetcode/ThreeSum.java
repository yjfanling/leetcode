package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> reslist=new LinkedList<List<Integer>>();
        List<Integer> list;
        Arrays.sort(nums);
        if(nums.length<3||nums[0]>0||nums[nums.length-1]<0)
        	return null;
        for(int i=0;i<nums.length-2;i++)
        {
        	
        	if(nums[i]>0)
        		break;
            while(i>0&&i<nums.length-2&&nums[i]==nums[i-1])
                i++;
        	int target=0-nums[i];
        	int k=i+1,j=nums.length-1;
        	while(k<j)
        	{
        		if(nums[k]+nums[j]==target)
        		{
                    list=new LinkedList<Integer>();
        			list.add(nums[i]);
	        		list.add(nums[k]);
	        		list.add(nums[j]);
                    reslist.add(list);
	        		while(k<j&&nums[k]==nums[k+1])k++;
	        		while(k<j&&nums[j]==nums[j-1])j--;
	        		k++;
	        		j--;
        		}
        		else if(nums[k]+nums[j]<target)
        			k++;
        		else
        			j--;
        	}
        	
        }
		return reslist;
    }
	@Test
	public void test(){
		int[] nums={-2,-4,-2};
		System.out.println(threeSum(nums));
	}
}
