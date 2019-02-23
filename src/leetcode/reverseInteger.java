package leetcode;

public class reverseInteger {
	 public int reverse(int x) {
			int res=0;
			while(x!=0)
			{
				if(Math.abs(res)>Integer.MAX_VALUE/10)
					return 0;
				res=res*10+x%10;
				x=x/10;
			}
			return res;
	}
	 public int reverse1(int x) {
			int res=0;
			while(x!=0)
			{
				int tmp=res*10+x%10;
				if(tmp/10!=res)
					return 0;
				res=tmp;
				x=x/10;
			}
			return res;
		    }
}
