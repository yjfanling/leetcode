package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<Integer> list;
        if(nums.length<4)
        	return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++)
        {
        	if(i>0&&i<nums.length-4&&nums[i]==nums[i-1])
        		continue;
        	for(int j=i+1;j<nums.length-2;j++)
        	{
            	if(j>i+1&&j<nums.length-4&&nums[j]==nums[j-1])
            		continue;
            	int start=j+1,end=nums.length-1;
            	while(start<end)
            	{
            		int sum=nums[i]+nums[j]+nums[start]+nums[end];
            		if(sum==target)
            		{
            			list=new ArrayList<Integer>();
            			list.add(nums[i]);
            			list.add(nums[j]);
            			list.add(nums[start]);
            			list.add(nums[end]);
            			res.add(list);
            			while(start<end&&nums[start]==nums[start+1])
            				start++;
            			while(start<end&&nums[end]==nums[end-1])
            				end--;
            			start++;
            			end--;
            		}
            		else if(target<sum)
            			end--;
            		else
            			start++;
            	}
        	}
        }
        return res;
    }
//	public List<List<Integer>> fourSum1(int[] nums, int target){
//		List<List<Integer>> res=new ArrayList<List<Integer>>();
//        List<Integer> list;
//        if(nums.length<4)
//        	return res;
//        Arrays.sort(nums);
//        Hashtable<Integer, List<List<Integer>>> table=new Hashtable<Integer, List<List<Integer>>>();
//        for(int i=0;i<nums.length-1;i++)
//        	for(int j=i+1;j<nums.length;j++)
//        	{
//        		int diff=target-(nums[i]+nums[j]);
//        		if(table.containsKey(diff))
//        		{
//        			for( List<Integer> l:table.get(target-(nums[i]+nums[j])))
//        			{
//        					list=new ArrayList<Integer>();
//        					list.add(nums[i]);
//        					list.add(nums[j]);
//        					list.add(l.get(0));
//        					list.add(l.get(1));
//        					res.add(list);
//        			}
//        		}else if(table.containsKey(nums[i]+nums[j]))
//        		{
//        			List<List<Integer>> tmp=table.get(nums[i]+nums[j]);
//        			List<Integer> t=new ArrayList<Integer>();
//        			t.add(nums[i]);
//        			t.add(nums[j]);
//        			tmp.add(t);
//        			table.replace(nums[i]+nums[j], tmp);
//        		}
//        		else
//        		{
//        			List<List<Integer>> tmp=new ArrayList<List<Integer>>();
//        			List<Integer> t=new ArrayList<Integer>();
//        			t.add(nums[i]);
//        			t.add(nums[j]);
//        			tmp.add(t);
//        			table.put(nums[i]+nums[j], tmp);
//        		}
//        			
//        	}
//        return res;
//	}

}
