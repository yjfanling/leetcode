package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class LongestCommonPrefix {
//	public String longestCommonPrefix(String[] strs)
//	{
//		if(strs==null||strs.length==0)
//			return "";
//		String common=new String(strs[0]);
//		for(int i=1;i<strs.length;i++)
//		{
//			if(common.equals(""))
//				return "";
//			int j;
//			for(j=0;j<common.length()&&j<strs[i].length();j++)
//			{
//				if(common.charAt(j)!=strs[i].charAt(j))
//					break;
//			}
//			common=common.substring(0, j);
//		}
//		return common;
//	}
	public String longestCommonPrefix(String[] strs)
	{
		if(strs==null||strs.length==0)
			return "";
		String res=new String();
		for(int i=0;i<strs[0].length();i++){
			char c=strs[0].charAt(i);
			for(int j=1;j<strs.length;j++)
			{
				if(i>strs[j].length()||strs[j].charAt(i)!=c)
					return res;
			}
			res+=Character.toString(c);
		}
		return strs[0];
	}
	public String longestCommonPrefix1(String[] strs){
		if(strs==null||strs.length==0)
			return "";
		Arrays.sort(strs);
		int i;
		for(i=0;i<strs[0].length()&&i<strs[strs.length-1].length();i++)
		{
			if(strs[0].charAt(i)!=strs[strs.length-1].charAt(i))
				break;
		}
		return strs[0].substring(0,i);
	}
	@Test
	public void test(){
		String[] strs={"dog"};
		System.out.println(longestCommonPrefix1(strs));
	}
}
