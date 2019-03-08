package leetcode;

import org.junit.Test;

public class DivideTwoIntegers {
	public int divide(int dividend,int divisor){
		if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        if(divisor==1)
            return dividend;
		boolean flag=false;
        if((dividend<0&&divisor<0)||(dividend>0&&divisor>0))
        	flag=true;
        long m=Math.abs((long)dividend);
        long n=Math.abs((long)divisor);
        long res=0;
        
        while(m>=n){
        	long t=n,count=1;
        	while(m>(t<<1))
        	{
        		t=t<<1;
        		count=count<<1;
        	}
        	res+=count;
        	m-=t;
        }
		return (int) (flag?res:-res);
	}
	@Test
	public void test(){
		System.out.println(divide(-2147483648,2));
	}
}
