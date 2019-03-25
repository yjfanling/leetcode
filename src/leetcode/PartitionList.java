package leetcode;

import org.junit.Test;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
        ListNode small=new ListNode(-1);
        ListNode big=new ListNode(-1);
        small.next=head;
        big.next=head;
        ListNode curbig=big;
        ListNode cursmall=small;
        while(head!=null){
        	if(head.val>=x)
        	{
        		cursmall.next=head.next;
        		curbig=curbig.next;
        	}
        	else
        	{
        		curbig.next=head.next;
        		cursmall=cursmall.next;
        	}
        	head=head.next;
        }
        cursmall.next=big.next;
		return small.next;
    }
	public ListNode partition1(ListNode head, int x) {
		ListNode res=new ListNode(-1);
		res.next=head;
		ListNode pre=res;
		ListNode cur=res;
		while(pre.next!=null&&pre.next.val<x)
			pre=pre.next;
		cur=pre;
		while(cur.next!=null)
		{
			if(cur.next.val<x){
				ListNode tmp=cur.next;
				cur.next=tmp.next;
				tmp.next=pre.next;
				pre.next=tmp;
				pre=pre.next;
			}
			else
				cur=cur.next;
		}
		return res.next;
	}
	@Test
	public void test(){
		ListNode head=new ListNode(-1);
		ListNode cur=head;
		cur.next=new ListNode(1);
		cur=cur.next;
		cur.next=new ListNode(4);
		cur=cur.next;
		cur.next=new ListNode(3);
		cur=cur.next;
		cur.next=new ListNode(2);
		cur=cur.next;
		cur.next=new ListNode(5);
		cur=cur.next;
		cur.next=new ListNode(2);
		cur=cur.next;
		cur.next=null;
		head=head.next;
		head=partition1(head, 3);
		while(head!=null)
		{
			System.out.println(head.val);
			head=head.next;
		}
	}
}
