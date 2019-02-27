package leetcode;

import org.junit.Test;

public class AddBinary {
	public String addBinary(String a, String b) {
		int n=a.length()-1,m=b.length()-1;
		int carry=0;
		String res="";
		while(n>=0||m>=0)
		{
			int p=n>=0?a.charAt(n--)-'0':0;
			int q=m>=0?b.charAt(m--)-'0':0;
			int sum=p+q+carry;
			res=(char)(sum%2+'0')+res;
			carry=sum/2;
		}
		return carry==1?(char)(1+'0')+res:res;
	}
	@Test
	public void test()
	{
		String a="100";
		String b="110010";
		System.out.println(addBinary(a, b));
	}
}
