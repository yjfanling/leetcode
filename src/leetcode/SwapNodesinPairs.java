package leetcode;

import org.junit.Test;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
        ListNode res=new ListNode(-1);
        res.next=head;
        ListNode pre =res;
        while(pre.next!=null&&pre.next.next!=null)
        {
        	ListNode tmp=pre.next.next;
        	pre.next.next=tmp.next;
        	tmp.next=pre.next;
        	pre.next=tmp;
        	pre=tmp.next;	
        }
        return res.next;
    }
	public ListNode swapPairs1(ListNode head) {
		 if (head==null || head.next==null) return head;
	     ListNode t = head.next;
	     head.next = swapPairs(head.next.next);
	     t.next = head;
	     return t;
	}
}
