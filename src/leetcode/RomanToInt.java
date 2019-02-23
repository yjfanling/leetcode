package leetcode;

import java.util.HashMap;

import org.junit.Test;
public class RomanToInt {
	public int romanToInt(String s) {
		if(s==null)
			return 0;
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			int tmp=map.get(s.charAt(i));
			while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1))
			{
				tmp+=map.get(s.charAt(i+1));
				i=i+1;
			}
			if(i+1<s.length()&&map.get(s.charAt(i))<map.get(s.charAt(i+1)))
			{
				tmp=map.get(s.charAt(i+1))-tmp;
				i=i+1;
			}
			res+=tmp;
		}
		return res;
	}
	public int romanToInt1(String s) {
		if(s==null)
			return 0;
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			int tmp=map(s.charAt(i));
			while(i+1<s.length()&&s.charAt(i)==s.charAt(i+1))
			{
				tmp+=map(s.charAt(i+1));
				i=i+1;
			}
			if(i+1<s.length()&&map(s.charAt(i))<map(s.charAt(i+1)))
			{
				tmp=map(s.charAt(i+1))-tmp;
				i=i+1;
			}
			res+=tmp;
		}
		return res;
	}
	public int romanToInt2(String s) {
		if(s==null)
			return 0;
		int res=0;
		for(int i=0;i<s.length()-1;i++)
		{
			int cur=map(s.charAt(i));
			int next=map(s.charAt(i+1));
			res+=cur>=next?cur:-cur;
		}
		res+=map(s.charAt(s.length()-1));
		return res;
	}
	private int map(char c) {
		// TODO Auto-generated method stub
		switch(c)
		{
		case 'I': 
			return 1;
        case 'V': 
        	return 5;
        case 'X': 
        	return 10;
        case 'L': 
        	return 50;
        case 'C': 
        	return 100;
        case 'D': 
        	return 500;
        case 'M': 
        	return 1000;
        default: 
        	return 0;
		}
	}
	@Test
	public void test()
	{
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		int res=0;
		String s="III";
		System.out.println(romanToInt2(s));
	}
}
