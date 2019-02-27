package leetcode;

import org.junit.Test;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null||s.length()==0)
			return 0;
		int right=s.length()-1,res=0;
		while(right>=0&&s.charAt(right)==' ')
			right--;
		while(right>=0&&s.charAt(right)!=' ')
		{
			right--;
			res++;
		}
		return res;
	}
	public int lengthOfLastWord1(String s){
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
	@Test
	public void test(){
		String s="a ";
		System.out.println(lengthOfLastWord1(s));
	}
}
