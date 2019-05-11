package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
	public static void main(String[] args){
		Stack<Integer> s=new Stack<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		ArrayList<Integer> a=new ArrayList<Integer>(s);
		Queue<Integer> q=new LinkedList<Integer>(s);
		System.out.println(q.poll());
		System.out.println(s.pop());
	}
}
