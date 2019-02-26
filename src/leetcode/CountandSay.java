package leetcode;

import org.junit.Test;

public class CountandSay {
	public String countAndSay(int n) {
        if(n<1)
        	return "";
        if(n==1)
        	return "1";
        StringBuilder pre=new StringBuilder("1");
        for(int i=2;i<=n;i++)
        {
        	StringBuilder tmp=new StringBuilder();
        	int count=1;
	        for(int j=0;j<pre.length();j++)
	        {
	        	while(j+1<pre.length()&&pre.charAt(j)==pre.charAt(j+1))
	        	{
	        		count++;
	        		j++;
	        	}
	        	tmp.append(count).append(pre.charAt(j));
	        	count=1;
	        }
			pre=tmp;
        }
        return pre.toString();
    }
	@Test
	public void test()
	{
		int n=6;
		System.out.println(countAndSay(n));
	}
}
