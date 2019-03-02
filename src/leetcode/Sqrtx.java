package leetcode;

import org.junit.Test;

public class Sqrtx {
	public int mySqrt(int x) {
		if(x==0)
			return 0;
		int start=1,end=x;
		while(start<end)
		{
			int mid=(start+end)/2;
			if(x/mid>=mid)
				start=mid+1;
			else
				end=mid;
		}
		return end-1;
    }
	public int mySqrt1(int x)
	{
		long res=x;
		while(res*res>x)
		{
			res=(res+x/res)/2;
		}
		return (int)res;
	}
	@Test
	public void test()
	{
		System.out.println(mySqrt(2147395600));
	}
}
