package leetcode;
import java.util.*;

import org.junit.Test;

public class SimplifyPath {
	public String simplifyPath(String path) {
		List<String> S=new LinkedList<String>();
        for(int i=0;i<path.length();i++)
        {
        	while(i<path.length()&&path.charAt(i)=='/')
        		i++;
        	if(i>=path.length())
        		break; 
        	int start=i;
        	while(i<path.length()&&path.charAt(i)!='/')
        		i++;
        	int end=i;
        	String s=path.substring(start,end);
        	if(s.equals(".."))
        	{
        		if(!S.isEmpty())
        			S.remove(S.size()-1);
        	}
        	else if(!s.equals("."))
        		S.add(s);
        }
        if(S.isEmpty())
        	return "/";
        String res="";
        for(int i=0;i<S.size();i++)
        	res=res+"/"+S.get(i);
        return res;
    }
	public String simplifyPath1(String path) {
        Stack<String> s = new Stack<String>();
        String[] p = path.split("/");
        for (String t : p) {
            if (!s.isEmpty() && t.equals("..")) {
                s.pop();
            } else if (!t.equals(".") && !t.equals("") && !t.equals("..")) {
                s.push(t);
            }
        }
        List<String> list = new ArrayList(s);
        return "/" + String.join("/", list);
	}
	@Test
	public void test(){
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/a/../../b/../c//.//"));
		System.out.println(simplifyPath("/a//b////c/d//././/.."));
		
		
	}
}
