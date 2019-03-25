package leetcode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode res=new ListNode(-1);
        ListNode cur=res;
        ListNode pre=head;
       while(pre.next!=null&&pre.val!=pre.next.val)
        {
            cur.next=pre;
            cur=cur.next;
            pre=pre.next;
        }    
        while(pre!=null&&pre.next!=null)
        {
        	while(pre.next!=null&&pre.val==pre.next.val)
        	{
        		pre=pre.next;
        	}
            	pre=pre.next;
        	if(pre==null||pre.next==null||pre.val!=pre.next.val)
        	{
        		cur.next=pre;
        		cur=cur.next;
        	}
        }
        return res.next;
    }
	public ListNode deleteDuplicates1(ListNode head) {
		if(head==null||head.next==null)
            return head;
        ListNode res=new ListNode(-1);
        ListNode pre=res;
        res.next=head;
        while(pre.next!=null)
        {
        	ListNode cur=pre.next;
        	while(cur.next!=null&&cur.val==cur.next.val)
        		cur=cur.next;
        	if(cur!=pre.next)
        		pre.next=cur.next;
        	else
        		pre=pre.next;
        }
        return res.next;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		if(head==null||head.next==null)
            return head;
		if(head.next!=null&&head.val==head.next.val){
			while(head.next!=null&&head.val==head.next.val)
				head=head.next;
			return deleteDuplicates(head.next);
		}
		head.next=deleteDuplicates(head.next);
		return head;
	}
}
