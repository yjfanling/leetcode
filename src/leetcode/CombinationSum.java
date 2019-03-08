package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res=new ArrayList<List<Integer>>();
        combinationSumDFS(res,target,candidates,0,new ArrayList<Integer>());
		return res;
    }

	private void combinationSumDFS(List<List<Integer>> res, int target, int[] candidates,int start, List<Integer> list) {
		// TODO Auto-generated method stub
		if(target<0	)
			return ;
		if(target==0){
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i=start;i<candidates.length;i++)
		{
			list.add(candidates[i]);
			combinationSumDFS(res,target-candidates[i], candidates,i, list);
			list.remove(list.size()-1);
		}
	}
	@Test
	public void test(){
		int[] candidates={2,5,2,1,2};
		int target=5;
		System.out.println(combinationSum(candidates, target));
	}
}
