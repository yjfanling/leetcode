package leetcode;

import java.util.HashMap;

import org.junit.Test;

public class TwoSum {
	public int[] twoSum(int[] nums,int target)
	{
		int[] result=new int[2];
		boolean isFind=false;
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]+nums[j]==target)
				{
					isFind=true;
					result[0]=i;
					result[1]=j;
					break;
				}
			}
			if(isFind)
				break;
		}
		return result;
	}
	public int[] twoSum1(int[] nums,int target)
	{
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++)
		{
			if(map.containsKey(target-nums[i]))
			{
				return new int[]{map.get(target-nums[i]),i};
			}
			else
			{
				map.put(nums[i], i);
			}
		}
		return null;
	}
	@Test
	public void test(){
		int[] a={2,4,3,6,7,2,4,2,6,3,7};
		int[] result=twoSum(a, 4);
		System.out.println(result[0]+","+result[1]);
	}
}
