package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0)
			return 0;
		int left=-1;
		int max=0;
		HashMap<Character,Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++)
		{
			if(map.containsKey(s.charAt(i))&&map.get(s.charAt(i))>left)
			{
				left=map.get(s.charAt(i));
				map.replace(s.charAt(i), i);
			}
			else
			{
				map.put(s.charAt(i), i);
			}
			max=max>i-left?max:i-left;	
		}
        
		return max;
    }
	public int lengthOfLongestSubstring1(String s) {
		int[] m=new int[256];
		Arrays.fill(m, -1);
		int max=0,left=-1;
		for(int i=0;i<s.length();i++)
		{
			left=Math.max(left, m[s.charAt(i)]);
			m[s.charAt(i)]=i;
			max=Math.max(max, i-left);
				
		}
		return max;
	}
	public int lengthOfLongestSubstring2(String s) {
		int max=0,left=0;
		HashSet<Character> t=new HashSet<Character>();
		for(int i=0;i<s.length();i++)
		{
			if(!t.contains(s.charAt(i)))
			{
				t.add(s.charAt(i));
				max=Math.max(max, t.size());
			}
			else
			{
				while(t.contains(s.charAt(i)))
					t.remove(s.charAt(left++));
				t.add(s.charAt(i));
			}
		}
		return max;
	}
	@Test
	public void test(){
		String s="dvdf";
		System.out.println(lengthOfLongestSubstring2(s));
	}
}
