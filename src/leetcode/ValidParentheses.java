package leetcode;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class ValidParentheses {
	public boolean isValid(String s) {
		if(s==null||s.length()==0)
			return true;
		if(!isOpen(s.charAt(0)))
			return false;
		StringBuffer tmp=new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
			if(isOpen(s.charAt(i)))
				tmp.append(symbol(s.charAt(i)));
			else if(tmp.length()>0&&s.charAt(i)==tmp.charAt(tmp.length()-1))
				tmp.deleteCharAt(tmp.length()-1);
			else 
				return false;
		}
		return tmp.length()==0?true:false;
    }
	public boolean isValid1(String s) {
		if(s==null||s.length()==0)
			return true;
		if(!isOpen(s.charAt(0)))
			return false;
		Stack<Character> stack=new Stack<Character>();
		for(int i=0;i<s.length();i++)
		{
			if(isOpen(s.charAt(i)))
				stack.add(symbol(s.charAt(i)));
			else if(!stack.isEmpty()&&s.charAt(i)==stack.peek())
				stack.pop();
			else 
				return false;
		}
		return stack.isEmpty()?true:false;
	}
	public Character symbol(char c)
	{
		switch(c)
		{
			case '(':
				return ')';
			case '{':
				return '}';
			case '[':
				return ']';
			default:
				return null;
		}
	}
	public boolean isOpen(char c){
		if(c=='('||c=='{'||c=='[')
			return true;
		return false;
	}
	@Test
	public void test()
	{
		String s1="()[]{}";
		String s2="(]";
		String s3="([)]";
		String s4="{[]}";
		String s5="[])";
		System.out.println(isValid1(s1));
		System.out.println(isValid1(s2));
		System.out.println(isValid1(s3));
		System.out.println(isValid1(s4));
		System.out.println(isValid1(s5));
	}
}
