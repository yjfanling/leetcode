package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		combinecore(n,k,1,res,new ArrayList<Integer>());
		return res;
    }

	private void combinecore(int n, int k, int level, List<List<Integer>> res, ArrayList<Integer> out) {
		// TODO Auto-generated method stub
		if(out.size()==k)
		{
			res.add(new ArrayList<Integer>(out));
			return;
		}
		for(int i=level;i<=n;i++)
		{
            if(out.size()+n-i+1<k)
                return;
			out.add(i);
			combinecore(n, k, i+1, res, out);
			out.remove(out.size()-1);
		}
	}
	public List<List<Integer>> combine1(int n, int k) {
		if(k>n||k<0)
			return new ArrayList<List<Integer>>();
		if(k==0)
		{
			List<Integer> out=new ArrayList<Integer>();
			List<List<Integer>> res=new ArrayList<List<Integer>>();
			res.add(out);
			return res;
		}
		List<List<Integer>> res=combine(n-1, k-1);
		for(List<Integer> a:res)
			a.add(n);
		for(List<Integer> a:combine(n-1, k))
			res.add(a);
		
		return res;
	}
	@Test
	public void test(){
		List<List<Integer>> res=combine(4, 2);
		System.out.println(res);
	}
}
