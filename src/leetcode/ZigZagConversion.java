package leetcode;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if(numRows<=1)
        	return s;
        StringBuffer res=new StringBuffer();
        int size=2*numRows-2;
        for(int i=0;i<numRows;i++)
        {
        	for(int j=i;j<s.length();j+=size)
        	{
        		res.append(s.charAt(j));
        		int tmp=j+size-2*i;
        		if(i!=0&&i!=numRows-1&&tmp<s.length())
        			res.append(s.charAt(tmp));
        	}
        }
        return res.toString();
    }
}
