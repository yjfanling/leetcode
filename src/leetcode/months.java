package leetcode;

import org.junit.Test;

public class months {
	public int getMonth(int[] months){
	    int[] m=new int[12];
	    int n=months.length;
	    for(int i=0;i<n;i++)
	    {
	        if(m[months[i]]>n/2)
	            return months[i];
	        m[months[i]]++;
	    }
	    return -1;
	}
	@Test
	public void test(){
		int[] A={1,2,3};
		System.out.println(getMonth(A));
	}
}
