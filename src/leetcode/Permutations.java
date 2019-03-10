package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
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
			visited[j]=true;
			list.add(nums[j]);
			permutedfs(nums, visited, list, res);
			list.remove(list.size()-1);
			visited[j]=false;
		}
	}
	@Test
	public void test(){
		int[] nums={1,2,3};
		List<List<Integer>> res=permute1(nums);
		System.out.println(res.toString());
	}
	public List<List<Integer>> permute1(int[] nums) {
		if(nums.length==1)
		{
			List<Integer>l=new ArrayList<Integer>();
			l.add(nums[0]);
			List<List<Integer>> res=new ArrayList<List<Integer>>();
			res.add(l);
			return res;
		}
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		int first=nums[0];
		int[] newnums=new int[nums.length-1];
		for(int i=nums.length-1;i>0;i--)
			newnums[i-1]=nums[i];
		List<List<Integer>> cur=new ArrayList<List<Integer>>(permute1(newnums));
		for(List<Integer> l:cur)
		{
			for(int i=0;i<=l.size();i++)
			{
				l.add(i, first);
				res.add(new ArrayList<Integer>(l));
				l.remove(i);
			}
		}
		return res;
	}
}
