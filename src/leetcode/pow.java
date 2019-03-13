package leetcode;

public class pow {
	public double myPow(double x, int n) {
        double res=1;
		for(int i=n;i!=0;i/=2){
        	if(i%2!=0)
        		res*=x;
        	x*=x;
        }
		return n>=0?res:1/res;
    }
	public double myPow1(double x, int n) {
		if(n==0)
			return 1;
		double half=myPow1(x,n/2);
		if(n%2==0)
			return half*half;
		if(n>0)
			return half*half*x;
		return half*half/x;
	}
}
