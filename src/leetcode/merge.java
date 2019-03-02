package leetcode;
import java.util.Stack;

import org.junit.Test;
public class merge {

	public int getkthOfTwoSortedArray(int[] A,int[] B,int k)
	{
	    Stack<Integer> s=new Stack<Integer>();
	    int t1=0,t2=0;
	    while(t1<A.length&&t2<B.length)
	    {
	        if(A[t1]<=B[t2])
	        {
	            s.push(A[t1]);
	            t1++;
	        }
	        else{
	            s.push(B[t2]);
	            t2++;
	        }
	        if(s.size()==k)
	            return s.peek();
	    }
	    return 0;
	}
	@Test
	public void test(){
		int[] A={1,5,9,10,36};
		int[] B={0,26,48};
		System.out.println(getkthOfTwoSortedArray(A, B, 3));
	}
	
}
