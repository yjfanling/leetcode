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
	            //Ѱ�ҿ����滻�����λ
	            for(int j = i+1 ; j<nums.length ; j++){
	                if(nums[i]<nums[j]){
	                    int temp = nums[i];
	                    nums[i] = nums[j];
	                    nums[j] = temp;
	                    //ȷ���滻λ�ĺ���λ��ֵ��С
	                    Arrays.sort(nums, i+1, nums.length);
	                    return;
	                }
	            }
	            //����ǰλ�����滻�����Ե�ǰλ��ʼ�����Ա�֤��һλ�����ڲ���������������ǰ�����ҵ���С�ĸ���ֵ
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
