package leetcode;

import org.junit.Test;

public class StringtoInteger {
	public int myAtoi(String str) {
        if(str==null||str.length()==0)
        	return 0;
        int i=0;
        while(i<str.length()&&str.charAt(i)==' ')
        	i++;
        int flag=1;
        if(i<str.length()&&(isValid(str.charAt(i))||isNumber(str.charAt(i))))
        {
        	if((str.charAt(i))=='-')
            {
        		flag=-1;
        		i++;
            }else if(str.charAt(i)=='+')
            	i++;
     	}
        else
        	return 0;
        int res=0;
        while(i<str.length()&&isNumber(str.charAt(i)))
        {
        	if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&str.charAt(i)-'0'>7))
        		return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        	res=res*10+(str.charAt(i++)-'0');
        	
        }
        return flag*res;
    }
	private boolean isNumber(char c){
		if(c-'0'>=0&&c-'0'<=9)
			return true;
		return false;
	}
	private boolean isValid(char charAt) {
		// TODO Auto-generated method stub
		if(charAt=='+'||charAt=='-')
			return true;
		return false;
	}
	@Test
	public void test()
	{
		String s="-2147483648";
		System.out.println(myAtoi(s));
	}
}
