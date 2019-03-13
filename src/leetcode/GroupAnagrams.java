package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res=new ArrayList<List<String>>();
		List<String> list=new ArrayList<String>();
		HashMap<String,List<String>> map=new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++)
		{
			String t=strs[i];
			char[] c=t.toCharArray();
			Arrays.sort(c);
			t=new String(c);
			if(map.containsKey(t))
			{
				list=map.get(t);
				list.add(strs[i]);
				map.replace(t, new ArrayList<String>(list));
			}
			else
			{
				list.add(strs[i]);
				map.put(t, new ArrayList<String>(list));
			}
			list.clear();
		}
		for(String s:map.keySet())
			res.add(map.get(s));
		return res;
    }
	public List<List<String>> groupAnagrams1(String[] strs){
		List<List<String>> res=new ArrayList<List<String>>();
		if(strs==null)
			return res;
		Map<String,List<String>> map=new HashMap<String, List<String>>();
		int[] count=new int[26];
		for(String s:strs)
		{
			Arrays.fill(count, 0);
			for(char c:s.toCharArray())
				count[c-'a']++;
			StringBuilder sb=new StringBuilder("");
			for(int i=0;i<26;i++)
                sb.append(count[i]);
			if(!map.containsKey(sb.toString()))
				map.put(sb.toString(), new ArrayList<String>());
			map.get(sb.toString()).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
	@Test
	public void test(){
		String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res=groupAnagrams1(strs);
	}
}
