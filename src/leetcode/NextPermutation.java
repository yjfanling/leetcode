package leetcode;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int n=nums.length;
        for( int i=n-2;i>=0;i--){
        	if(nums[i+1]>nums[i])
        	{
        		for(int j=n-1;j>i;j--){
        			if(nums[j]>nums[i])
        			{
        				int tmp=nums[j];
        				nums[j]=nums[i];
        				nums[i]=tmp;
        				Arrays.sort(nums, i+1, n);
        				return ;
        			}
        		}
        	}
        }
        Arrays.sort(nums);
    }
	 public void nextPermutation1(int[] nums) {
	        for(int i = nums.length - 2 ; i>=0 ; i--){
	            //寻找可以替换的最低位
	            for(int j = i+1 ; j<nums.length ; j++){
	                if(nums[i]<nums[j]){
	                    int temp = nums[i];
	                    nums[i] = nums[j];
	                    nums[j] = temp;
	                    //确保替换位的后续位的值最小
	                    Arrays.sort(nums, i+1, nums.length);
	                    return;
	                }
	            }
	            //若当前位不可替换，则自当前位开始排序，以保证下一位可以在不进行完整遍历的前提下找到最小的更大值
	            Arrays.sort(nums,i,nums.length);
	        }
	    }
	 public void nextPermutation2(int[] nums) {
	        int n=nums.length;
	        for( int i=n-2;i>=0;i--){
	        	if(nums[i+1]>nums[i])
	        	{
	        		for(int j=n-1;j>i;j--){
	        			if(nums[j]>nums[i])
	        			{
	        				swap(nums,i,j);
	        				reverse(nums, i+1, n-1);
	        				return ;
	        			}
	        		}
	        	}
	        }
	        reverse(nums,0,n-1);
	    }
	 private void reverse(int[] nums, int start, int end) {
		// TODO Auto-generated method stub
		while(start<end)
		{
			swap(nums,start++,end--);
		}
	}
	private void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
	@Test
	 public void test(){
		 int[] nums={1,2,7,4,3,1};
		 nextPermutation(nums);
	 }
}
