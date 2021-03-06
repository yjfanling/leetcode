package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> list=new ArrayList<String>();
		GenerateParenthesesdfs(list,"",n,n);
		return list;
    }

	private void GenerateParenthesesdfs(List<String> list, String s, int left,int right) {
		// TODO Auto-generated method stub
		if(left>right)
			return;
		if(left==0&&right==0)
			list.add(s);
		else
		{
			if(left>0)
				GenerateParenthesesdfs(list, s+'(', left-1, right);
			if(right>0)
				GenerateParenthesesdfs(list, s+')', left, right-1);
		}
	}
		
	@Test
	public void test(){
		System.out.println(generateParenthesis(3));
	}
}
