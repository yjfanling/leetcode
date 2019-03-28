package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int start) {
		// TODO Auto-generated method stub
		res.add(new ArrayList<Integer>(list));
		for(int i=start;i<nums.length;i++)
		{
			list.add(nums[i]);
			dfs(res,list,nums,i+1);
			list.remove(list.size()-1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) 
                ++i;            

		}
	}
	public List<List<Integer>> subsetsWithDup1(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		if(nums==null||nums.length==0)
			return res;
		Arrays.sort(nums);
		int size=1,last=nums[0];
		for(int i=0;i<nums.length;i++){
			if(last!=nums[i])
			{
				size=res.size();
				last=nums[i];
			}
			int newsize=res.size();
			for(int j=newsize-size;j<newsize;j++)
			{
				List<Integer> list=new ArrayList<Integer>(res.get(j));
				list.add(nums[i]);
				res.add(list);
			}
		}
		return res;
	}
	@Test
	public void test(){
		int[] nums={1,2,2};
		subsetsWithDup(nums);
	}
}
