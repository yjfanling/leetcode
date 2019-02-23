package leetcode;

import org.junit.Test;

public class Palindrom {
	public boolean isPalindrome(int x) {
	    if(x<0)
			return false;
		int tmp=reverse(x);
		return tmp==x?true:false;
	}
	public int reverse(int x)
	{
		int res=0;
		while(x!=0)
		{
			res=res*10+x%10;
			x=x/10;
		}
		return res;
	}
	public boolean isPalindrome1(int x) {
		if(x<0||(x!=0&&x%10==0))
			return false;
		int tmp=0;
		while(x>tmp)
		{
			tmp=tmp*10+x%10;
			x=x/10;
		}
		return (x==tmp||x==tmp/10)?true:false;
	}
}
