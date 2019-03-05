package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<String>();
        if(digits.length()==0)
            return list;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        letterCombinationsdfs(list,digits,"",0,map);
        return list;
    }

	private void letterCombinationsdfs(List<String> list, String digits, String res, int index, String[] map) {
		// TODO Auto-generated method stub
		if(index==digits.length())
		{
			list.add(res);
			return ;
		}
		String str=map[digits.charAt(index)-'0'];
		for(int i=0;i<str.length();i++)
		{
			letterCombinationsdfs(list, digits, res+str.charAt(i), index+1, map);
		}
	}
	public List<String> letterCombinations1(String digits){
		 List<String> list=new ArrayList<String>();
	        if(digits.length()==0)
	            return list;
	        list.add("");
	        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        for(int i=0;i<digits.length();i++)
	        {
	        	List<String> tmp=new ArrayList<String>();
	        	String str=map[digits.charAt(i)-'0'];
	        	for(int j=0;j<str.length();j++)
	        	{
	        		for(String s:list)
	        		{
	        			tmp.add(s+str.charAt(j));
	        		}
	        	}
	        	list=tmp;
	        }
	        return list;
	}
	@Test
	public void test()
	{
		String s="456";
		System.out.println(letterCombinations1(s));
	}
}
