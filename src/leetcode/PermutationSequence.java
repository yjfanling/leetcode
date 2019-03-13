package leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
        	list.add(i);
        int an=(k-1)/f(n-1);
        int kn=(k-1)%f(n-1);
        String res=String.valueOf(list.get(an));
        list.remove(an);
        for(int i=2;i<=n;i++)
        {
        	an=kn/f(n-i);
        	kn=(k-1)%f(n-i);
        	res=res+String.valueOf(list.get(an));
        	list.remove(an);
        }
        return res;
	}
	private int f(int i) {
		// TODO Auto-generated method stub
		int res=1;
		for(int j=2;j<=i;j++)
			res*=j;
		return res;
	}
	@Test
	public void test(){
		
	}
}
