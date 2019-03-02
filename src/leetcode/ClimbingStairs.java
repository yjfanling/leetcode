package leetcode;

public class ClimbingStairs {
	public int climbStairs(int n) {
        if(n<=2)
        	return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
	public int climbStairs1(int n){
		if(n<=2)
			return n;
		int step1=1;
		int step2=2;
		for(int i=3;i<=n;i++)
		{
			int sum=step1+step2;
			step1=step2;
			step2=sum;
		}
		return step2;
	}
}
