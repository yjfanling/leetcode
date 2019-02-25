package leetcode;

import java.util.HashMap;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) 
	{
		int length=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(!map.containsKey(nums[i]))
			{	
				nums[length]=nums[i];
				map.put(nums[i],1);
				length++;
			}
		}
		return length;
	 }
	public int removeDuplicates1(int[] nums) 
	{
		if(nums==null||nums.length==0)
			return 0;
		int length=0;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i]!=nums[length])
			{
				length++;
				nums[length]=nums[i];
			}
		}
        length++;
		return length;
	 }
}
