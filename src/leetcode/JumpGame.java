package leetcode;

public class JumpGame {
	public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)
        	return true;
        int n=nums.length;
		int[] dp=new int[n];
		for(int i=1;i<n;i++)
		{
			dp[i]=Math.max(dp[i-1], nums[i-1])-1;
			if(dp[i]<0)
				return false;
		}
		return true;
    }
	public boolean canJump1(int[] nums) {
		if(nums==null||nums.length==0)
        	return true;
        int n=nums.length;
        int reach=0;
        for(int i=0;i<n;i++)
        {
        	if(i>reach||reach>=n-1)
        		break;
        	reach=Math.max(reach, i+nums[i]);
        }
        return reach>n-1;
	}
}
