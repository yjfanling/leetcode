package leetcode;

import org.junit.Test;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
        int max=0;
        for(int i=0;i<height.length;i++)
        {
        	for(int j=i+1;j<height.length;j++)
        	{
        		max=Math.max(Math.min(height[i],height[j])*(j-i), max);
        	}
        }
        return max;
    }
	public int maxArea1(int[] height){
		int max=0,left=0,right=height.length-1;
		while(left<right)
		{
			int h=Math.min(height[left], height[right]);
			max=Math.max(max, h*(right-left));
			while(left<right&&h==height[left])
				left++;
			while(right>left&&h==height[right])
				right--;
		}
		return max;
	}
	@Test
	public void test(){
		int[] height={1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}
}
