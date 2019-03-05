package leetcode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res=new ListNode(-1);
        ListNode tmp=res;
		ListNode curr=head;
        ListNode pre=head;
        while(n>0)
        {
        	pre=pre.next;
        	n--;
        }
        if(pre==null)
        	return head.next;
        while(pre.next!=null)
        {
        	pre=pre.next;
        	curr=curr.next;
        }
        curr.next=curr.next.next;
		return head;
    }
}
