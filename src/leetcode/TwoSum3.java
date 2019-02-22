package leetcode;

import java.util.HashMap;

import org.junit.Test;

public class TwoSum3 {
	private HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	public void add(int key)
	{
		if(map.containsKey(key))
			map.put(key,map.get(key)+1);
		else
			map.put(key, 1);
	}
	public boolean find(int target)
	{
		for(int i:map.keySet())
		{
			if((target-i==i&&map.get(i)>1)||(target-i!=i&&map.containsKey(target-i)))
				return true;	
//			if(map.containsKey(target-i))
//			{
//				if(target-i!=i)
//					return true;
//				else
//				{
//					if(map.get(i)>1)
//						return true;
//				}
//			}
		}
		return false;
	}
	@Test
	public void test(){
		TwoSum3 t=new TwoSum3();
		t.add(6);
		t.add(3);
		t.add(8);
		t.add(2);
		System.out.println(t.find(4));
		System.out.println(t.find(7));
	}
}
