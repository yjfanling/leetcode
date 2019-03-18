package leetcode;

public class SortColors {
	public void sortColors(int[] nums) {
		if(nums.length==0||nums==null)
			return;
		int n=nums.length;
		int red=0,blue=n-1;
		for(int i=0;i<n;i++)
		{
			if(nums[i]==0)
				swap(nums,red++,i);
			else if(nums[i]==2)
				swap(nums,blue--,i);
		}
        
    }

	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
}
