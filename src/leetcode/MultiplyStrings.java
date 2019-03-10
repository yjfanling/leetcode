package leetcode;

import org.junit.Test;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        int n=num1.length(),m=num2.length();
        int[] sums=new int[m+n];
        int k=n+m-2,carry=0;
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<m;j++)
        	{
        		sums[k-i-j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        	}
        }
        for(int i=0;i<n+m;i++)
        {
        	sums[i]+=carry;
        	carry=sums[i]/10;
        	sums[i]=sums[i]%10;
        }
        int i=n+m-1;
        while(i>=0&&sums[i]==0)
        	--i;
        if(i<0)
        	return "0";
        String res="";
        while(i>=0)
        {
        	res=res+sums[i--];
        }
        return res;
    }
	@Test
	public void test(){
		System.out.println(multiply("0", "0"));
	}
}
