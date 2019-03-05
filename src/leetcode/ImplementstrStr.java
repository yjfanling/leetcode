package leetcode;

import org.junit.Test;

public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if(needle==null||needle.length()==0)
			return 0;
		int curindex=0;
		for(int i=0;i<=haystack.length()-needle.length();i++)
		{
			int start=i;
			while(start<haystack.length()&&curindex<needle.length()&&haystack.charAt(start)==needle.charAt(curindex))
			{
				start++;
				curindex++;
			}
			if(start!=i)
			{
				if(curindex==needle.length())
					return i;
				else
					curindex=0;
			}
		}
		return -1;   
    }
	public int strStr1(String haystack, String needle){
		if(needle.length()==0||needle==null)
			return 0;
		int n=haystack.length();
		int m=needle.length();
		if(n<m)
			return -1;
		for(int i=0;i<=n-m;i++)
		{
			int j=0;
			while(j<needle.length()&&haystack.charAt(i+j)==needle.charAt(j))
			{
				j++;
			}
			if(j==m)
				return i;
		}
			
		return -1;
	}
}
