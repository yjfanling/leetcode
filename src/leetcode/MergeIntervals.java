package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res=new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0)
			return res;
		intervals.sort(new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
			
		});
		int n=intervals.size();
		Interval I=intervals.get(0);
		res.add(intervals.get(0));
		for(int i=1;i<n;i++)
		{
			if(res.get(res.size()-1).end>=intervals.get(i).start)
				res.get(res.size()-1).end=Math.max(intervals.get(i).end,res.get(res.size()-1).end);
			else
				res.add(intervals.get(i));			
		}
		return res;
    }
	public List<Interval> merge1(List<Interval> intervals) {
		List<Interval> res=new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0)
			return res;
		int n=intervals.size();
		int[] starts=new int[n];
		int[] ends=new int[n];
		int i=0;
		for(Interval I:intervals)
		{
			starts[i]=I.start;
			ends[i++]=I.end;
		}
		Arrays.sort(starts);
        Arrays.sort(ends);
		int j=0;
		for(i=0;i<n;i++)
		{
			if(i==n-1||starts[i+1]>ends[i])
			{
				res.add(new Interval(starts[j],ends[i]));
				j=i+1;
			}
		}
		return res;
	}
}