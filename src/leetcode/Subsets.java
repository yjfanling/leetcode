package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		for(int i=0;i<=nums.length;i++)
			combinecore(nums,i,0,res,new ArrayList<Integer>());
		return res;
    }
	private void combinecore(int[] nums, int k, int level, List<List<Integer>> res, ArrayList<Integer> out) {
		// TODO Auto-generated method stub
		if(out.size()==k)
		{
			res.add(new ArrayList<Integer>(out));
			return;
		}
		for(int i=level;i<nums.length;i++)
		{
			if(nums.length-i<(k-out.size()-1))
				return;
			out.add(nums[i]);
			combinecore(nums, k, i+1, res, out);
			out.remove(out.size()-1);
		}
	}
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for(int i=0;i<nums.length;i++)
		{
			int size=res.size();
			for(int j=0;j<size;j++)
			{
				List<Integer> newres=new ArrayList<Integer>(res.get(j));
				newres.add(nums[i]);
				res.add(newres);
			}
		}
		return res;
	}
	@Test
	public void test(){
		int[] nums={1,2,3};
		List<List<Integer>> res=subsets1(nums);
		System.out.println(res);
	}
}
