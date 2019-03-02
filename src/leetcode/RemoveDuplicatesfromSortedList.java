package leetcode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        while(head!=null)
        {
        	while(head.next!=null&&head.val==head.next.val)
        		head=head.next;
            cur.next=head;
        	head=head.next;
            cur=cur.next;
        	
        }
		return res.next;
    }
	public ListNode deleteDuplicates1(ListNode head) {
		ListNode cur=head;
		while(cur!=null||cur.next!=null)
		{
			if(cur.val==cur.next.val)
				cur.next=cur.next.next;
			else
				cur=cur.next;
		}
		return head;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null||head.next==null)
			return head;
		head.next=deleteDuplicates(head.next);
		return head.val==head.next.val?head.next:head;
	}
}
