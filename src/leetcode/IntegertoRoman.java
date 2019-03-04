package leetcode;

import org.junit.Test;

public class IntegertoRoman {
	public String intToRoman(int num) {
		String s="";
		char[] roman={'M', 'D', 'C', 'L', 'X', 'V', 'I'};
		int[] value={1000,500,100,50,10,5,1};
		for(int i=0;i<7;i+=2)
		{
			int x=num/value[i];
			if(x<4)
				for(int j=1;j<=x;j++)
					s+=roman[i];
			else if(x==4)
			{
				s=s+roman[i]+roman[i-1];
			}
			else if(x>4&&x<9)
			{
				s+=roman[i-1];
				for(int j=6;j<=x;j++)
					s+=roman[i];
			}
			else
				s=s+roman[i]+roman[i-2];
			num%=value[i];
		}
		return s;
    }
	@Test
	public void test(){
		System.out.println(intToRoman(4));
	}
}
