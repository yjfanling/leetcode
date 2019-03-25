package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		return grayCodecore(n);
	}

	private List<Integer> grayCodecore(int n) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		if (n == 0)
			list.add(0);
		else if (n == 1) {
			Integer[] array = { 0, 1};
			Collections.addAll(list, array);
		} else {
			list = grayCodecore(n - 1);
			for (int i = list.size() - 1; i >= 0; i--)
				list.add((int) (list.get(i) + Math.pow(2, n - 1)));
		}
		return list;
	}
	public List<Integer> grayCode1(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<Math.pow(2, n);i++)
			list.add((i>>1)^i);
		return list;
	}
}
