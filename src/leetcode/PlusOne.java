package leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
        int n=digits.length;
        int cur=1;
        for(int i=n-1;i>=0;i--)
        {
        	if(digits[i]==9&&cur==1)
        	{
        		digits[i]=0;
        		cur=1;
        	}
        	else
        	{
        		digits[i]+=cur;
        		cur=0;
        	}
        }
        if(digits[0]==0)
        {
        	int[] res=new int[n+1];
        	res[0]=1;
        	for(int i=0;i<n;i++)
        	{
        		res[i+1]=digits[i];
        	}
        	return res;
        }
        return digits;
    }
	public int[] plusOne1(int[] digits) {
		int n=digits.length;
		for(int i=n-1;i>=0;i--)
		{
			if(digits[i]<9)
			{
				digits[i]++;
				return digits;
			}
			digits[i]=0;
		}
		int[] res=new int[n+1];
		res[0]=1;
		return res;
	}
}
