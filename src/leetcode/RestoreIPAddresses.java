package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        core(s,0,"",res);
        return res;
    }

	private void core(String s, int n, String out, List<String> res) {
		// TODO Auto-generated method stub
		if(n==4)
		{
			if(s.isEmpty())
				res.add(out);
			return;
		}
		for(int k=1;k<4;k++){
			if(s.length()<k)
				break;
			int val=Integer.parseInt(s.substring(0, k));
			if(val>255||k!=String.valueOf(val).length())
				continue;
			core(s.substring(k), n+1, out+s.substring(0,k)+(n==3?"":"."), res);
		}
	}
}
