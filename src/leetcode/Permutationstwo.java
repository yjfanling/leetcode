package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Permutationstwo {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		Arrays.sort(nums);
		boolean[] visited=new boolean[nums.length];
		permutedfs(nums,visited,list,res);
		return res;
    }

	private void permutedfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
		// TODO Auto-generated method stub
		if(list.size()==nums.length)
		{
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int j=0;j<nums.length;j++)
		{
			if(visited[j])
				continue;
			if ((j>0 && nums[j] == nums[j - 1])&&!visited[j-1])
				continue;
			visited[j]=true;
			list.add(nums[j]);
			permutedfs(nums, visited, list, res);
			list.remove(list.size()-1);
			visited[j]=false;
		}
	}
	@Test
	public void test(){
		int[] nums={1,1,2};
		List<List<Integer>> res=permuteUnique(nums);
		System.out.println(res.toString());
	}
}
