package leetcode;

import org.junit.Test;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix==null)
        	return false;
        int n=matrix.length,m=matrix[0].length;
        int start=0,end=n-1;
        while(start<=end)
        {
        	int mid=(start+end)/2;
        	if(matrix[mid][m-1]==target)
                return true;
        	else if (matrix[mid][m-1]<target)
                start=mid+1;
            else
                if(matrix[mid][0]==target)
                    return true;
                else if(matrix[mid][0]>target)
                    end=mid-1;
                else
                {
                    int startr=0;
                    int endr=m-1;
                    while(startr<=endr)
                    {
                    	int midr=(startr+endr)/2;
                        if(matrix[mid][midr]==target)
                            return true;
                        else if(matrix[mid][midr]>target)
                            endr=midr;
                        else
                            startr=midr+1;
                    }
                    return false;
                }
        }
        return false;
    }
	@Test
	public void test(){
		int[][] matrix={{1,2,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(matrix, 13));
	}
}
