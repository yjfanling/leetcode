package leetcode;

import org.junit.Test;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
            return head;
        ListNode cur=head;
        ListNode pre=head;
        ListNode back=new ListNode(-1);
        back.next=head;
        int length=1;
        while(pre.next!=null)
        {
        	pre=pre.next;
        	length++;
        }
        k=k%length;
        if(k==0)
        	return head;
        pre=head;
        for(int i=1;i<k;i++)
        {
        	if(pre.next==null)
        		pre=head;
        	else
        		pre=pre.next;
        }
        while(pre.next!=null)
        {
        	pre=pre.next;
        	cur=cur.next;
        	back=back.next;
        }
        pre.next=head;
        back.next=null;
		return cur;
    }
	public ListNode rotateRight1(ListNode head, int k) {
		 if(head==null||head.next==null||k==0)
	            return head;
	        ListNode cur=head;
	        int length=1;
	        while(cur.next!=null)
	        {
	        	cur=cur.next;
	        	length++;
	        }
	        cur.next=head;
	        cur=head;
	        for(int i=1;i<k-k%length;i++)
	        {
	        	cur=cur.next;
	        }
	        ListNode newNode=cur.next;
	        cur.next=null;
	        return newNode;
	        
	}
	@Test
	public void test(){
		ListNode l=new ListNode(1);
		l.next=new ListNode(2);
		System.out.println(rotateRight1(l,2).next.val);
	}
}
