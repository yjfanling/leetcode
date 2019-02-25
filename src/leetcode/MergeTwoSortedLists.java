package leetcode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode res=new ListNode(-1);
		ListNode cur=res;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val)
        	{
        		cur.next=l1;
        		l1=l1.next;
        	}
        	else
        	{
        		cur.next=l2;
        		l2=l2.next;
        	}
        	cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
		return res.next;
    }
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1==null)
			return l2;
		ListNode res=l1;
		while(l2!=null)
		{
			if(res.val<l2.val)
			{
				if(res.next!=null)
					res=res.next;
				else
				{
					res.next=l2;
					return l1;
				}
			}
			else if(res.val==l2.val)
			{
				ListNode tmp=new ListNode(l2.val);
				tmp.next=res.next;
				res.next=tmp;
				l2=l2.next;
				res=res.next;	
			}
			else
			{
				ListNode tmp=new ListNode(res.val);
				tmp.next=res.next;
				res.val=l2.val;
				res.next=tmp;
				l2=l2.next;
			}
		}
		
		return l1;
	}
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1==null||(l2!=null&&l1.val>l2.val))
		{
			ListNode t=l1;
			l1=l2;
			l2=t;
		}
		if(l1!=null)
		{
			l1.next=mergeTwoLists(l1.next, l2);
		}
		return l1;
	}
}
